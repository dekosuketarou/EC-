<%-- 
    Document   : mydata_update
    Created on : 2017/09/26, 22:36:35
    Author     : DEKO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/stylesheet.css" rel="stylesheet">
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="base">
            <div class="container-fluid text-center"><a href="top.jsp"><img src="かごゆめ.png"></a></div>
            <hr>
            <div class="container-fluid text-center">
                <div class="col-xs-4 center-block"><a href="Logout">ログアウト</a></div>
                <div class="col-xs-4 center-block"><a href="MyData">会員情報</a></div>
                <div class="col-xs-4 center-block"><a href="Cart">買い物カゴ</a></div>
            </div>
            <hr>
            <div class="container-fluid">
                <div class="col-xs-6 col-xs-offset-3">
                    <form action="MyUpdateResult" method="post">
                        <table class="container-fluid table">
                            <tr><th class="text-right">名前</th><td><input type="text" name="name" class="form-control" required="required" value="${sessionScope.login.name}"></td></tr>
                            <tr><th class="text-right">パスワード</th><td><input type="text" required="required" name="password" class="form-control" value="${sessionScope.login.password}"></td></tr>
                            <tr><th class="text-right">メールアドレス</th><td><input type="email" name="mail" class="form-control" required="required" value="${sessionScope.login.mail}"></td></tr>
                            <tr><th class="text-right">住所</th><td><input type="text" name="address" class="form-control" required="required" value="${sessionScope.login.address}"></td></tr>
                        </table>
                        
                        <div class="container-fluid"><input type="submit" value="登録確認" class="form-control"></div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
