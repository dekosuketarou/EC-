<%-- 
    Document   : registration_complete
    Created on : 2017/09/26, 22:35:32
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
        <div>
            <table>
            <tr><th>名前</th><td>${requestScope.udb.name}</td></tr>
        <tr><th>パスワード</th><td>${requestScope.udb.password}</td></tr>
        <tr><th>メールアドレス</th><td>${requestScope.udb.mail}</td></tr>
        <tr><th>住所</th><td>${requestScope.udb.address}</td></tr>
        <tr><td colspan="2">上記内容で登録いたしました</td></tr></table>
        </div>
    </body>
</html>
