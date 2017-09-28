<%-- 
    Document   : login
    Created on : 2017/09/26, 22:34:37
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
        <form action="LoginResult" method="post">
            <ul>
                <li><input type="text" required="required" placeholder="ユーザー名" name="name"></li>
                <li><input type="password" required="required" placeholder="パスワード" name="password"></li>
                <li><input type="submit" value="ログイン"></li>
            </ul>
        </form>
    </body>
</html>
