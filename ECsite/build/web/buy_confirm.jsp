<%-- 
    Document   : buy_confirm
    Created on : 2017/09/26, 22:37:52
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
        <c:if test="${sessionScope.login==null}"><%request.getRequestDispatcher("Login").forward(request, response);%></c:if>
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

                    <table class="container-fluid table">
                        <tr><td class="text-center" style="font-size:18px;">商品名</td><td style="font-size: 18px;width: 70px;">金額</td></tr>
                        <c:forEach items="${sessionScope.sdbAL}" var="sdb">
                            <c:set var="total" >${total+sdb.price}</c:set>
                            <tr><td> ${sdb.item}</td><td>${sdb.price}円</td></tr>
                        </c:forEach>
                        <tr><th colspan="2" class="text-center">合計金額：${total}円</th></tr>
                    </table>
                    <form action="BuyComplete" method="POST">
                        <div style="width: 300px;margin: auto;">
                            <input type="radio" name="type" value="1" checked="checked">通常発送(夢の中に届きます)<br>
                            <input type="radio" name="type" value="2">爆速発送（心の中に特急で届きます）<br>
                            <input type="radio" name="type" value="3">未来発送（未来で購入したら届きます）
                        </div>
                        
                    <br>
                        <div class="container-fluid"><input type="submit" value="上記の内容で購入する" class="form-control"></div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
