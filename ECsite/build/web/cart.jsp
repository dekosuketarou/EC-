<%-- 
    Document   : cart
    Created on : 2017/09/26, 22:37:36
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.ShopDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>かいものかご</title>
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
                <div class="col-xs-4 center-block"><a href="top.jsp">検索ページ</a></div>
            </div>
            <hr>
            <div class="container-fluid">
                <div class="col-xs-6 col-xs-offset-3">
                    <c:choose>
                        <c:when test="${sessionScope.login!=null}">

                            <c:choose>
                                <c:when test="${sessionScope.sdbAL.size()!=0&&sessionScope.sdbAL.size()!=null}">
                                    <div style="width: 560px;margin: auto;">
                                    <table class="container-fluid table">
                                        <c:forEach items="${sessionScope.sdbAL}" var="sdb" varStatus="index">
                                            <tr><td rowspan="2"><form action="Remove"><input type="hidden" name="remove" value="${index.index}"><input type="submit" value="削除"></form></td>
                                                <td rowspan="2"><img src="${sdb.imageURL}" width="100"></td><td>${sdb.item}</td></tr>
                                            <tr><td>${sdb.price}円(税込み)</td></tr>
                                            <c:set var="total">${total+sdb.price}</c:set>
                                        </c:forEach>
                                            <tr><th colspan="3" class="text-center">合計金額は${total}円です</th></tr>
                                        <tr><td colspan="3">
                                                <div class="container-fluid text-center"><a href="BuyConfirm">購入する</a></div>
                                        
                                            </td></tr>
                                    </table>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                   <div class="container-fluid text-center"><h3>カゴの中に何もありません</h3></div> 
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <%request.getRequestDispatcher("Login").forward(request, response);%>
                        </c:otherwise>  
                    </c:choose>

                </div>
            </div>
        </div>
    </body>
</html>
