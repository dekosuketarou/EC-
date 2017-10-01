<%-- 
    Document   : add
    Created on : 2017/09/26, 22:37:24
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
            <hr>
            <c:choose>
                <c:when test="${sessionScope.login!=null}">
                    <div class="container-fluid text-center ">
                        <div class="col-xs-3 center-block"><a href="Logout">ログアウト</a></div>
                        <div class="col-xs-3 center-block"><a href="MyData">会員情報</a></div>
                        <div class="col-xs-3 center-block"><a href="Cart">買い物カゴ</a></div>
                        <div class="col-xs-3 center-block"><a href="top.jsp">検索ページ</a></div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="container-fluid text-center"><a href="Login">ログインページへ</a></div>
                </c:otherwise>
            </c:choose>
            <hr>

            <div class="container-fluid">
                <div class="col-xs-6 col-xs-offset-3">
                    
                    <div class="container-fluid text-center"><h3>商品をカートに追加しました</h3></div>
                </div>
            </div>
        </div>
    </body>
</html>
