<%-- 
    Document   : mydata
    Created on : 2017/09/26, 22:35:48
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
                <div class="col-xs-4 center-block"><a href="Cart">買い物カゴ</a></div>
                <div class="col-xs-4 center-block"><a href="top.jsp">検索ページ</a></div>
            </div>
            <hr>
            <div class="container-fluid">
                <div class="col-xs-6 col-xs-offset-3">
                    <div style="width: 350px;margin: auto;">
                    <table class="container-fluid table">
                        <tr><td class="text-right" style="width: 175px;">ユーザー名</td><td style="width: 175px;">${sessionScope.login.getName()}</td></tr>
                        <tr><td class="text-right">パスワード</td><td>${sessionScope.login.getPassword()}</td></tr>
                        <tr><td class="text-right">メールアドレス</td><td>${sessionScope.login.getMail()}</td></tr>
                        <tr><td class="text-right">住所</td><td>${sessionScope.login.getAddress()}</td></tr>
                        <tr><td class="text-right">総購入金額</td><td>${sessionScope.login.getTotal()}</td></tr>
                        <tr><td class="text-right">登録日時</td><td>${sessionScope.login.getNewDate()}</td></tr>
                        <tr><td class="text-center"><a href="myupdate.jsp">会員情報変更</a></td><td class="text-center"><a href="MyHistory">購入履歴</a></td></tr>
                        <tr><td colspan="2" class="text-center"><a href="mydelete.jsp">退会申請ページ</a></td></tr>     
                    </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
