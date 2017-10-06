<%-- 
    Document   : top
    Created on : 2017/09/26, 22:35:57
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <c:choose>
                        <c:when test="${sessionScope.login!=null}">


                    <hr>
                    <div class="container-fluid text-center">
                        <div class="col-xs-4 center-block"><a href="Logout" >ログアウト</a></div>
                        <div class="col-xs-4 center-block"><a href="MyData">会員情報</a></div>
                        <div class="col-xs-4 center-block"><a href="Cart">買い物カゴ</a></div>
                    </div>
                    <hr>
                    <div class="container-fluid text-center">ようこそ&nbsp;<a href="MyData">${sessionScope.login.name}</a>&nbsp;さん！</div>
                </c:when>
                <c:otherwise> 
                    <hr>
                    <div class="container-fluid text-center"><a href="Login">ログインページへ</a></div>
                    <hr>
                </c:otherwise>
            </c:choose>
            <div class="container-fluid">
                <div class="col-xs-6 col-xs-offset-3">
                    <form action="Search" method="POST">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        <input type="text" name="query" class=" form-control" placeholder="<c:choose><c:when test="${empty requestScope.error}">キーワードを入力してください</c:when><c:otherwise>${requestScope.error}</c:otherwise></c:choose>">
                        <input type="hidden" value="0" name="offset">
                    </form>

                </div>
            </div>
    </body>
</html>
