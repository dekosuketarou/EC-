/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECsiteLogic;

import Data.ShopDataBeans;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static java.net.URLEncoder.encode;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DEKO
 */
public class LogicBeans {

    public static LogicBeans getInstance() {
        return new LogicBeans();
    }

    //request.getParameter("query")
    public HttpServletRequest searchItem(HttpServletRequest request) throws IOException {
        ArrayList<ShopDataBeans> AL = new ArrayList<>();
        String shopAPI = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
        String appid = "?appid=dj00aiZpPVNLU1d6RGVMdjdyaiZzPWNvbnN1bWVyc2VjcmV0Jng9NDM-";
        String query = "&query=" + encode(request.getParameter("query"), "UTF-8");
        String offset = "&offset=" + request.getParameter("offset");
        URL url = new URL(shopAPI + appid + query + offset);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.connect();

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(urlCon.getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(parser);
        JsonNode result = rootNode.get("ResultSet").get("0").get("Result");

        for (int i = 0; i < 10; i++) {
            String index = String.valueOf(i);
            ShopDataBeans sdb = new ShopDataBeans();
            sdb.setItemCode(result.get(index).get("Code").textValue());
            sdb.setItem(result.get(index).get("Name").textValue());//codesearchでも利用
            sdb.setDesc(result.get(index).get("Description").textValue());
            sdb.setImageURL(result.get(index).get("Image").get("Small").textValue());//codesearchでも利用
            sdb.setPrice(result.get(index).get("Price").get("_value").textValue());//codesearchでも利用
            AL.add(sdb);
        }

        request.setAttribute("hit", rootNode.get("ResultSet").get("totalResultsAvailable"));
        request.setAttribute("searchResult", AL);
        return request;
    }

    public ShopDataBeans oneSearch(String code) throws IOException {
        String shopAPI = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
        String appid = "?appid=dj00aiZpPVNLU1d6RGVMdjdyaiZzPWNvbnN1bWVyc2VjcmV0Jng9NDM-";
        String responsegroup = "&responsegroup=medium";
        String imgSize="&image_size=300";
        String itemcode = "&itemcode=" + code;

        URL url = new URL(shopAPI + appid + itemcode + responsegroup+imgSize);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.connect();

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(urlCon.getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(parser);
        
        ShopDataBeans sdb = new ShopDataBeans();
        
        JsonNode result = rootNode.get("ResultSet").get("0").get("Result").get("0");
        sdb.setItemCode(result.get("Code").textValue());
        sdb.setItem(result.get("Name").textValue());
        sdb.setDesc(result.get("Description").textValue());
        sdb.setImageURL(result.get("ExImage").get("Url").textValue());
        sdb.setPrice(result.get("Price").get("_value").textValue());

        return sdb;
    }
}
