<%-- 
    Document   : mydelete_result
    Created on : 2017/09/30, 19:05:10
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
        <c:if test="${sessionScope.login==null}"><%request.getRequestDispatcher("Login").forward(request, response);%></c:if>
    </head>
    <body>
        <div class="base">
            <div class="container-fluid text-center"><a href="top.jsp"><img src="かごゆめ.png"></a></div>
            <hr>
            <div class="container-fluid text-center"><a href="Login?return=top.jsp">ログインページへ</a></div>
            <hr>
            <div class="container-fluid">
                <div class="col-xs-6 col-xs-offset-3">
                    <h1 class="text-center">削除しました</h1>
                </div>
            </div>
        </div>
    </body>
</html>
