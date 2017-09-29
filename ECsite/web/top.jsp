<%-- 
    Document   : top
    Created on : 2017/09/26, 22:35:57
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ECsiteLogic.MenuHelper" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <c:choose>
        <c:when test="${sessionScope.login!=null}">
                <%=MenuHelper.getInstance().getUpMenu()%>
        </c:when>
        <c:otherwise> 
            <form action="Login" method="POST">
                <input type="hidden" value="top.jsp" name="return">
                <input type="submit" value="ログインページへ">
            </form>
        </c:otherwise>
    </c:choose>
        <hr>
        <form action="Search">
            <input type="text" name="query">
            <input type="hidden" value="0" name="offset">
            <input type="submit" value="検索">
        </form>
    </body>
</html>
