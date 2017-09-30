<%-- 
    Document   : buy_complete
    Created on : 2017/09/26, 22:39:46
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
        <hr>
        <h1>購入が完了しました</h1>

    </body>
</html>
