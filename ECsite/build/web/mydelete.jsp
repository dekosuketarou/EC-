<%-- 
    Document   : mydelete
    Created on : 2017/09/30, 18:50:29
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
            <tr><td>ユーザーID</td><td>${sessionScope.login.getUserID()}</td></tr>
            <tr><td>ユーザー名</td><td>${sessionScope.login.getName()}</td></tr>
            <tr><td>パスワード</td><td>${sessionScope.login.getPassword()}</td></tr>
            <tr><td>メールアドレス</td><td>${sessionScope.login.getMail()}</td></tr>
            <tr><td>住所</td><td>${sessionScope.login.getAddress()}</td></tr>
            <tr><td>総購入金額</td><td>${sessionScope.login.getTotal()}</td></tr>
            <tr><td>登録日時</td><td>${sessionScope.login.getNewDate()}</td></tr>

            <tr><td colspan="2"><h2>このユーザーをマジで削除しますか？</h2></td></tr>
            <tr><td>
                    <a href="MyDeleteResult">はい</a>
                </td>
                <td>
                    <a href="top.jsp">いいえ</a>
                </td></tr>
        </table>
    </body>
</html>
