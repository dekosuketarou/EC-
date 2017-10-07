/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECsiteLogic;

import Data.CartItem;
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
import javax.servlet.http.HttpSession;

/**
 * サーブレットやJavaBeansで使うロジックをここにまとめている getInstance()によりコードを簡略化
 */
public class LogicBeans {

    public static LogicBeans getInstance() {
        return new LogicBeans();
    }

    /**
     * YahooAPIのひとつであるshoppingWEB APIを使用して商品検索をするメソッド
     * フォームデータやクエストリングを利用してAPIに必要な情報を取得する
     *
     * @query 検索キーワード //パーセントエンコードにより日本語入力に対応
     * @offset 表示する商品の番号 for文の数字を増やすことによって取得することが出来る商品数を指定できる
     */
    public void searchItem(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        ArrayList<ShopDataBeans> searchResult = new ArrayList<>();
        //検索キーワードや各種要素によって商品情報を取得することが出来るYahooAPI
        String shopAPI = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
        //YahooAPIから情報を取得するためのappID情報
        String appid = "?appid=dj00aiZpPVNLU1d6RGVMdjdyaiZzPWNvbnN1bWVyc2VjcmV0Jng9NDM-";
        //検索キーワードをencodeメソッドにより日本語に対応
        String query = "&query=" + encode(request.getParameter("query"), "UTF-8");
        //offsetにより取得順番を指定（初期値は0である）
        String offset;
        //offsetの数値+hitsの数値が1000を超えるとエラーコードが帰ってくるため
        //APIリクエストパラメータであるoffsetが990以上である場合は990にする
        if (Integer.parseInt(request.getParameter("offset"))>990) {
            offset = "&offset=990";
        } else {
            offset = "&offset=" + request.getParameter("offset");
        }
        String hits = "&hits=10";
        URL url = new URL(shopAPI + appid + query + offset + hits);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.connect();

        //jacksonAPIによりjsonpファイルを要素ごとに分化
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(urlCon.getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(parser);
        JsonNode result = rootNode.get("ResultSet").get("0").get("Result");
        //該当商品があった場合は１０件商品情報を格納しsessionにsearchResultとして登録
        //該当商品がなかった場合これまでのsearchResultを破棄する

        //検索結果0だった場合true
        boolean totalResultFlg = rootNode.get("ResultSet").get("totalResultsAvailable").textValue().equals("0");
        //jsonデータがerror通知だった場合false
        boolean jsonStreamError = (rootNode.get("Error") == null);

        if (!totalResultFlg && jsonStreamError) {
            int ArrayIndex = rootNode.get("ResultSet").get("totalResultsReturned").asInt();
            for (int i = 0; i < ArrayIndex; i++) {
                //jacksonAPIの要素指定はString出しか出来ないのでindexを変換
                String index = String.valueOf(i);
                ShopDataBeans sdb = new ShopDataBeans();
                sdb.setItemCode(result.get(index).get("Code").textValue());
                sdb.setItem(result.get(index).get("Name").textValue());//codesearchでも利用
                sdb.setDesc(result.get(index).get("Description").textValue());
                sdb.setImageURL(result.get(index).get("Image").get("Small").textValue());//codesearchでも利用
                sdb.setPrice(result.get(index).get("Price").get("_value").textValue());//codesearchでも利用
                searchResult.add(sdb);

            }

            /**
             * 必要な情報をsessionに登録する
             *
             * @totalResultAvailableは検索にhitした商品の数　わかりやすくセッション登録名はhit
             * @searchResult 取得した商品情報の配列　ShopDataBeansは商品情報格納のための変数を持つBeans
             */
            session.setAttribute("hit", rootNode.get("ResultSet").get("totalResultsAvailable").textValue());
            session.setAttribute("searchResult", searchResult);

        } else {
            session.setAttribute("hit", "0");
            session.removeAttribute("searchResult");
        }
    }

    /**
     * @ShopDateBeansのフィールドitemCodeを引数に渡すことで商品情報を取得することが出来るメソッド
     * @itemCodeはYahooAPIにより取得できる商品コードである 本メソッドでは単一の商品情報を取得する
     */
    public ShopDataBeans oneSearch(String code) throws IOException {
        //itemCodeにより商品情報を取得することが出来るYahooAPI
        String shopAPI = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
        String appid = "?appid=dj00aiZpPVNLU1d6RGVMdjdyaiZzPWNvbnN1bWVyc2VjcmV0Jng9NDM-";
        //取得する情報量の大きさを決める
        String responsegroup = "&responsegroup=medium";
        //取得する画像データの大きさを決める
        //指定サイズはそれぞれ　76/106/132/146/300/600
        String imgSize = "&image_size=300";
        //引数として受け取った商品コード
        String itemcode = "&itemcode=" + code;

        URL url = new URL(shopAPI + appid + itemcode + responsegroup + imgSize);
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
        sdb.setReviewRate(result.get("Review").get("Rate").textValue());
        sdb.setReviewCount(result.get("Review").get("Count").textValue());

        return sdb;
    }

    //itemCodeの数だけ商品情報を取得するメソッド
    public ArrayList<ShopDataBeans> cartSearch(CartItem cartItem) throws IOException {
        ArrayList<ShopDataBeans> sdbAL = new ArrayList<>();
        for (String code : cartItem.getCartItem()) {
            sdbAL.add(oneSearch(code));
        }
        return sdbAL;
    }
}
