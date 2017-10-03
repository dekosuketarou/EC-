<%-- 
    Document   : search
    Created on : 2017/09/26, 22:36:02
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.ShopDataBeans"%>
<%@page import="java.util.ArrayList"%>
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
            <c:when test="${sessionScope.hit!=null}">
                <c:choose>
                    <c:when test="${sessionScope.login!=null}">
                        <div class="container-fluid text-center">
                            <div class="col-xs-4 center-block"><a href="Logout">ログアウト</a></div>
                            <div class="col-xs-4 center-block"><a href="MyData">会員情報</a></div>
                            <div class="col-xs-4 center-block"><a href="Cart">買い物カゴ</a></div>
                        </div>
                    </c:when>
                    <c:otherwise> 
                        <div class="container-fluid text-center"><a href="Login?return=search.jsp">ログインページへ</a></div>

                    </c:otherwise>
                </c:choose>
                <hr>
                <div class="container ">
                    <div class="col-xs-8 col-xs-offset-2">
                        <form action="Search">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                            <input type="text" name="query" class=" form-control" value="${sessionScope.keyword}" placeholder="<c:choose><c:when test="${empty requestScope.error}">キーワードを入力してください</c:when><c:otherwise>${requestScope.error}</c:otherwise></c:choose>">
                            <br>    <select name="offset">
                                <option  value="0">----------------</option>
                                <%for (int i = 0; i < Integer.parseInt((String) session.getAttribute("hit")) / 10; i++) {%>
                                <%if (i == 30) {
                                        break;
                                    }%>
                                <option  value="<%=i * 10%>"><%=i + 1%>ページ目</option>
                                <%}%>
                            </select>
                        </form>


                        <h3 class="text-center">検索キーワード「${sessionScope.keyword}」で検索した結果</h3>
                        <h3 class="text-center">
                            <c:choose><c:when test="${sessionScope.hit==0}">商品が見つかりませんでした</c:when><c:otherwise>商品が${sessionScope.hit}件見つかりました</c:otherwise></c:choose></h3>

                            <c:forEach items="${sessionScope.searchResult}" var="sdb">
                                <table style="margin: 10px;"> 
                                    <tr><td rowspan="2"><img src="${sdb.imageURL}" width="100"></td><td><a href="Item?code=${sdb.itemCode}">${sdb.item}</a></td></tr>
                                    <tr><td>${sdb.price}円(税込み)</td></tr>
                                </table>
                            </c:forEach>
                        </c:when>
                        <c:otherwise><%request.getRequestDispatcher("top.jsp").forward(request, response);%></c:otherwise>
                    </c:choose>
  
            </div>
        </div>
        </div>
        <hr>
    </body>
</html>
