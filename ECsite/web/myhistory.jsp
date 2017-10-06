<%-- 
    Document   : myhistory
    Created on : 2017/09/30, 16:29:58
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
            <div class="container text-center">
                <div class="col-xs-4 center-block"><a href="Logout">ログアウト</a></div>
                <div class="col-xs-4 center-block"><a href="MyData">会員情報</a></div>
                <div class="col-xs-4 center-block"><a href="Cart">買い物カゴ</a></div>
            </div>
            <hr>
            <div class="container-fluid">
                <div class="col-xs-8 col-xs-offset-2">
                    <div class="container-fluid text-center"><h3>購入履歴</h3></div> 
                    <c:choose>
                        <c:when test="${sessionScope.myhistory.size()!=0}">
                            <div style="width:400px;margin: auto;font-size: 12px;">
                                <table class="container-fluid table">
                                    <tr><td></td><td class="text-center" style="font-size: 20px">商品名</td><td style="font-size: 20px;width: 70px">金額</td></tr>
                                    <c:forEach items="${sessionScope.myhistory}" var="myhistory">
                                        <c:set var="total" >${total+myhistory.price}</c:set>
                                        <tr><td><img src="${myhistory.imageURL}" width="70"></td><td><a href="Item?code=${myhistory.itemCode}">${myhistory.item}</a></td><td>${myhistory.price}円</td></tr>
                                            </c:forEach>
                                    <tr><th colspan="3" class="text-center"><h3>合計金額：${total}円</h3></th></tr>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <h1 class="text-center">買った夢がありません</h1>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <hr>
        </div>
    </body>
</html>
