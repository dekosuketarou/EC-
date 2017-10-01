<%-- 
    Document   : item
    Created on : 2017/09/26, 22:36:02
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.ShopDataBeans"%>
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
            <div class="container-fluid">
                <c:choose>
                    <c:when test="${sessionScope.login!=null}">
                        <div class="container-fluid text-center">
                            <div class="col-xs-4 center-block"><a href="Logout">ログアウト</a></div>
                            <div class="col-xs-4 center-block"><a href="MyData">会員情報</a></div>
                            <div class="col-xs-4 center-block"><a href="Cart">買い物カゴ</a></div>
                        </div>               
                    </c:when>
                    <c:otherwise>
                        <div class="container-fluid text-center"><a href="Login?return=item.jsp">ログインページへ</a></div>
                    </c:otherwise>
                </c:choose>
                <hr>
                <div class="col-xs-6 col-xs-offset-3">
                    <div style="width: 560px;margin: auto;">
                        <table class="container-fluid table">
                            <tr><td rowspan="3"><img src="${sessionScope.oneSearch.getImageURL()}" width="150"></td><td>${sessionScope.oneSearch.getItem()}</td></tr>
                            <tr><td>価格：${sessionScope.oneSearch.getPrice()}円</td></tr>
                            <tr><td>${sessionScope.oneSearch.getReviewCount()}人のレビュー平均値は${sessionScope.oneSearch.getReviewRate()}です</td></tr>
                            <tr><td colspan="2">${sessionScope.oneSearch.getDesc()}<td></tr>
                            <tr><td colspan="2">
                                    <div class="container-fluid text-center"><a href="Add?code=${sessionScope.oneSearch.getItemCode()}">カートに追加</a></div>
                                <td></tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
