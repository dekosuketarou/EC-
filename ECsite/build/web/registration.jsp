<%-- 
    Document   : registration
    Created on : 2017/09/26, 22:34:57
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>かいいんとうろく</title>
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
                <form action="RegistrationConfirm" method="post">
                    
                    <table class="container-fluid table">
                        <tr><th class="text-right">名前</th><td><input type="text" name="name" class="form-control" maxlength="20" placeholder="<c:if test="${empty sessionScope.registration.name && !empty sessionScope.registration}">未記入です</c:if>" value="<c:if test="${sessionScope.registration!=null}">${sessionScope.registration.name}</c:if>"></td></tr>
                        <tr><th class="text-right">パスワード</th><td><input type="password" name="password" class="form-control" maxlength="20" placeholder="<c:if test="${empty sessionScope.registration.password && !empty sessionScope.registration}">未記入です</c:if>"value="<c:if test="${sessionScope.registration!=null}">${sessionScope.registration.password}</c:if>"></td></tr>
                        <tr><th class="text-right">メールアドレス</th><td><input type="email" name="mail" class="form-control"maxlength="50" placeholder="<c:if test="${empty sessionScope.registration.mail && !empty sessionScope.registration}">未記入です</c:if>" value="<c:if test="${sessionScope.registration!=null}">${sessionScope.registration.mail}</c:if>"></td></tr>
                        <tr><th class="text-right">住所</th><td><input type="text" name="address" class="form-control" maxlength="100"placeholder="<c:if test="${empty sessionScope.registration.address && !empty sessionScope.registration}">未記入です</c:if>" value="<c:if test="${sessionScope.registration!=null}">${sessionScope.registration.address}</c:if>"></td></tr>
                    </table>
                        <div class="container-fluid"><input type="submit" value="登録確認ページへ" class="form-control"></div>
                   
                </form>
            </div>
        </div>
        </div>
    </body>
</html>
