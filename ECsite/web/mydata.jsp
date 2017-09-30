<%-- 
    Document   : mydata
    Created on : 2017/09/26, 22:35:48
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
        <%=MenuHelper.getInstance().getTopMenu()%>
        <hr>
        <table>
            <tr><td>ユーザー名</td><td>${sessionScope.login.getName()}</td></tr>
            <tr><td>パスワード</td><td>${sessionScope.login.getPassword()}</td></tr>
            <tr><td>メールアドレス</td><td>${sessionScope.login.getMail()}</td></tr>
            <tr><td>住所</td><td>${sessionScope.login.getAddress()}</td></tr>
            <tr><td>総購入金額</td><td>${sessionScope.login.getTotal()}</td></tr>
            <tr><td>登録日時</td><td>${sessionScope.login.getNewDate()}</td></tr>
            <tr><td><%=MenuHelper.getInstance().getMyUpdateMenu()%></td><td><%=MenuHelper.getInstance().getMyDeleteMenu()%></td></tr>
            <tr><td colspan="2"><%=MenuHelper.getInstance().getMyHistoryMenu()%></td></tr>        
        
        </table>
    </body>
</html>
