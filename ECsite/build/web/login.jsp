<%-- 
    Document   : login
    Created on : 2017/09/26, 22:34:37
    Author     : DEKO
--%>

<%@page import="ECsiteLogic.MenuHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=MenuHelper.getInstance().getTopMenu()%>
        <hr>
        <c:if test="${requestScope.Flg==1}">このユーザーアカウントは削除されています</c:if>
        <c:if test="${requestScope.Flg==-1}">入力した名前、パスワードが一致しません</c:if>
        <c:choose>
            <c:when test="${sessionScope.login==null}">   

                <form action="LoginResult" method="post">
                    <ul>
                        <li><input type="text" required="required" placeholder="ユーザー名" name="name" value="${cookie.name.value}"></li>
                        <li><input type="password" required="required" placeholder="パスワード" name="password" value="${cookie.password.value}"></li>
                        <li><input type="checkbox" name="cookie" value="true">ログイン情報を保存しますか？
                        <li><a href="registration.jsp">新規登録ページ</a></li>
                        <li><input type="submit" value="ログイン"></li>
                    </ul>
                </form>

            </c:when>
            <c:otherwise><%
                request.getRequestDispatcher("top.jsp").forward(request, response);
                %></c:otherwise>          
        </c:choose>
    </body>
</html>
