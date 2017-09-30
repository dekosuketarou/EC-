<%-- 
    Document   : mydata_update
    Created on : 2017/09/26, 22:36:35
    Author     : DEKO
--%>

<%@page import="ECsiteLogic.MenuHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=MenuHelper.getInstance().getLogoutMenu()%>
        <%=MenuHelper.getInstance().getMyDataMenu()%>
        <%=MenuHelper.getInstance().getTopMenu()%>
        <hr>
        <form action="MyUpdateResult" method="post">
            <table>
                <tr><th>名前</th><td><input type="text" name="name" required="required" value="${sessionScope.login.name}"></td></tr>
                <tr><th>パスワード</th><td><input type="text" required="required" name="password" value="${sessionScope.login.password}"></td></tr>
                <tr><th>メールアドレス</th><td><input type="email" name="mail" required="required" value="${sessionScope.login.mail}"></td></tr>
                <tr><th>住所</th><td><input type="text" name="address" required="required" value="${sessionScope.login.address}"></td></tr>
                <tr><th colspan="2"><input type="submit" value="登録確認">
                    </th></tr>
            </table>
        </form>

    </body>
</html>
