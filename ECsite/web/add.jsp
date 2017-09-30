<%-- 
    Document   : add
    Created on : 2017/09/26, 22:37:24
    Author     : DEKO
--%>

<%@page import="ECsiteLogic.MenuHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>            
        <%=MenuHelper.getInstance().getLogoutMenu()%>
        <%=MenuHelper.getInstance().getMyDataMenu()%>
        <%=MenuHelper.getInstance().getCartMenu()%>
        <%=MenuHelper.getInstance().getTopMenu()%>
        <hr>
        <h3>商品をカートに追加しました</h3>
    </body>
</html>
