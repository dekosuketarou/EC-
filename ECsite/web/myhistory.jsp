<%-- 
    Document   : myhistory
    Created on : 2017/09/30, 16:29:58
    Author     : DEKO
--%>

<%@page import="ECsiteLogic.MenuHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=MenuHelper.getInstance().getLogoutMenu()%>
        <%=MenuHelper.getInstance().getMyDataMenu()%>
        <%=MenuHelper.getInstance().getCartMenu()%>
        <%=MenuHelper.getInstance().getTopMenu()%>
        <hr>
        <c:choose>
            <c:when test="${sessionScope.myhistory!=null}">
                
        <table>
            <tr><td>商品名</td><td>金額</td></tr>
            <c:forEach items="${sessionScope.myhistory}" var="myhistory">
                <c:set var="total" >${total+myhistory.price}</c:set>
                <tr><td><img src="${myhistory.imageURL}" width="50"></td><td><a href="Item?code=${myhistory.itemCode}">${myhistory.item}</a></td><td>${myhistory.price}円</td></tr>
            </c:forEach>
            <tr><th colspan="3">合計金額：${total}円</th></tr>
        </table>
            </c:when>
        <c:otherwise>
            <h1>買った夢がありません</h1>
        </c:otherwise>
        </c:choose>
    </body>
</html>
