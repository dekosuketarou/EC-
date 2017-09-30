<%-- 
    Document   : myupdate_result
    Created on : 2017/09/30, 18:21:18
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
        <table>
            <tr><th>名前</th><td>${sessionScope.login.name}</td></tr>
            <tr><th>パスワード</th><td>${sessionScope.login.password}</td></tr>
            <tr><th>メールアドレス</th><td>${sessionScope.login.mail}</td></tr>
            <tr><th>住所</th><td>${sessionScope.login.address}</td></tr>
            <tr><td colspan="2">上記内容で更新いたしました</td></tr></table>
    </body>
</html>
