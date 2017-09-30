<%-- 
    Document   : item
    Created on : 2017/09/26, 22:36:02
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ECsiteLogic.MenuHelper"%>
<%@page import="Data.ShopDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.login!=null}">
                <%=MenuHelper.getInstance().getLogoutMenu()%>
                <%=MenuHelper.getInstance().getMyDataMenu()%>
                <%=MenuHelper.getInstance().getCartMenu()%>
                
            </c:when>
            <c:otherwise>
                <form action="Login" method="POST">
                    <input type="hidden" value="item.jsp" name="return">
                    <input type="submit" value="ログインページへ">
                </form>
            </c:otherwise>
        </c:choose>
        <hr>
        <table>
            <tr><td rowspan="3"><img src="${sessionScope.oneSearch.getImageURL()}" width="150"></td><td>${sessionScope.oneSearch.getItem()}</td></tr>
            <tr><td>価格：${sessionScope.oneSearch.getPrice()}円</td></tr>
            <tr><td>${sessionScope.oneSearch.getReviewCount()}人のレビュー平均値は${sessionScope.oneSearch.getReviewRate()}です</td></tr>
            <tr><td colspan="2">${sessionScope.oneSearch.getDesc()}<td></tr>
            <tr><td colspan="2">
                    <form action="Add">
                        <input type="hidden" name="code" value="${sessionScope.oneSearch.getItemCode()}">
                        <input type="submit" value="カートに追加"></form>
                <td></tr>
        </table>
    </body>
</html>
