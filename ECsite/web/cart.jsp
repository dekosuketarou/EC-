<%-- 
    Document   : cart
    Created on : 2017/09/26, 22:37:36
    Author     : DEKO
--%>

<%@page import="ECsiteLogic.MenuHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
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
                <%=MenuHelper.getInstance().getTopMenu()%>
                <hr>
                <c:choose>
                    <c:when test="${sessionScope.sdbAL.size()!=0&&sessionScope.sdbAL.size()!=null}">
                        <table>
                            <c:forEach items="${sessionScope.sdbAL}" var="sdb" varStatus="index">
                                <tr><td rowspan="2"><form action="Remove"><input type="hidden" name="remove" value="${index.index}"><input type="submit" value="削除"></form></td>
                                    <td rowspan="2"><img src="${sdb.imageURL}" width="100"></td><td>${sdb.item}</td></tr>
                                <tr><td>${sdb.price}円(税込み)</td></tr>
                                <c:set var="total">${total+sdb.price}</c:set>
                            </c:forEach>
                            <tr><th colspan="2">合計金額は${total}円です</th></tr>
                            <tr><td colspan="2">
                                    <form action="BuyConfirm" method="post">
                                        <input type="hidden" name="price" value="total">
                                        <input type="submit" value="購入する">
                                    </form>
                                </td></tr>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <h1>かごの中に商品が入っておりません</h1>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <%request.getRequestDispatcher("Login").forward(request, response);%>
            </c:otherwise>  
        </c:choose>

    </body>
</html>
