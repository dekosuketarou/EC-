<%-- 
    Document   : search
    Created on : 2017/09/26, 22:36:02
    Author     : DEKO
--%>

<%@page import="Data.ShopDataBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%
        ArrayList<ShopDataBeans>AL=(ArrayList<ShopDataBeans>)request.getAttribute("searchResult");
        
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${hit.toString().replace("\"","")}件の検索結果がありました。</h1>
        <%for(ShopDataBeans sdb:AL){%>
        <table>
            <tr><td rowspan="2"><img src="<%=sdb.getImageURL()%>" ></td><td><a href="Item?code=<%=sdb.getItemCode()%>"><%=sdb.getItem()%></a></td></tr>
            <tr><td><%=sdb.getPrice()%>円(税込み)</td></tr>
        </table>
            <%}%>
    </body>&itemcode=happyricejapan_kytg10
</html>
