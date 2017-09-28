<%-- 
    Document   : registration_confirm
    Created on : 2017/09/26, 22:35:19
    Author     : DEKO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr><th>名前</th><td>${sessionScope.udb.name}</td></tr>
            <tr><th>パスワード</th><td>${sessionScope.udb.password}</td></tr>
            <tr><th>メールアドレス</th><td>${sessionScope.udb.mail}</td></tr>
            <tr><th>住所</th><td>${sessionScope.udb.address}</td></tr>
            <tr><td colspan="2">上記内容で登録しますがよろしいでしょうか？</td></tr>
            <tr><td>
                    <form action="RegistrationComplete">
                        <input type="submit" value="登録する">
                    </form></td><td>
                    <form action="registration.jsp">
                        <input type="submit" value="登録画面に戻る">
                    </form></td></tr></table>
    </body>
</html>
