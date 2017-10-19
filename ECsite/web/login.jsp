<%-- 
    Document   : login
    Created on : 2017/09/26, 22:34:37
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
        <title>ろぐいん</title>
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
                    <c:when test="${sessionScope.login==null}">  
                        <div class="col-xs-4 col-xs-offset-4 ">
                            <div style="width:280px;margin: auto;">
                                <div style="width: 280px;text-align: center;"><c:if test="${requestScope.Flg==1}">削除されたアカウントです</c:if></div>

                                    <div style="width:280px; text-align: center;"><c:if test="${requestScope.Flg==-1}"> 名前、パスワードが一致しません</c:if></div>
                                    <form action="LoginResult" method="post">
                                        <ul class="list-group-item media-list">
                                            <li class="media-heading"><input type="text" required="required" placeholder="ユーザー名" class="form-control input-sm" name="name" value="${cookie.name.value}"></li>
                                        <li class="media-heading"><input type="password" required="required" placeholder="パスワード" class="form-control input-sm" name="password" value="${cookie.password.value}"></li>
                                        <li class="media-heading"><input type="checkbox" name="cookie" value="true" ><span style="font-size:12px">ログイン情報を保存する</span></li>
                                        <li class="media-heading"><input type="submit" value="ログイン"  class="form-control"></li>
                                        <li><a href="Registration"><span style="font-size: 12px">新規登録ページ</span></a></li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise><%
                        request.getRequestDispatcher("top.jsp").forward(request, response);
                        %></c:otherwise>          
                </c:choose>
        </div>
        </div>
    </body>
</html>
