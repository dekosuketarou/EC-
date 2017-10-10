<%-- 
    Document   : registration_confirm
    Created on : 2017/09/26, 22:35:19
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
        <div class="container-fluid text-center"><a href="Login">ログインページへ</a></div>
        <hr>
        <div class="container-fluid">
            <div class="col-xs-6 col-xs-offset-3">
                <p class="text-center">下記内容で登録しますがよろしいでしょうか？</p>
                <table class="container-fluid table">
                    <tr><th class="text-right">名前</th><td>${sessionScope.registration.name}</td></tr>
                    <tr><th class="text-right">パスワード</th><td>${sessionScope.registration.password}</td></tr>
                    <tr><th class="text-right">メールアドレス</th><td>${sessionScope.registration.mail}</td></tr>
                    <tr><th class="text-right">住所</th><td>${sessionScope.registration.address}</td></tr>

                    <tr>
                        <td class="text-center">
                            <a href="RegistrationComplete">登録する</a>
                        </td>
                        <td class="text-center"><a href="registration.jsp">登録画面に戻る</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
</div>
    </body>
</html>
