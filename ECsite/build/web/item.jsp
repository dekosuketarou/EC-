<%-- 
    Document   : item
    Created on : 2017/09/26, 22:36:02
    Author     : DEKO
--%>

<%@page import="Data.ShopDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%
        ShopDataBeans sdb=(ShopDataBeans)request.getAttribute("oneSearch");
        
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr><td rowspan="2"><img src=<%=sdb.getImageURL()%> ></td><td><%=sdb.getItem()%></td></tr>
            <tr><td><%=sdb.getDesc()%></td></tr>
        </table>
    </body>
</html>
