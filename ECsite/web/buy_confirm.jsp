<%-- 
    Document   : buy_confirm
    Created on : 2017/09/26, 22:37:52
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
        <%=MenuHelper.getInstance().getLogoutMenu()%>
        <%=MenuHelper.getInstance().getMyDataMenu()%>
        <%=MenuHelper.getInstance().getCartMenu()%>
        <hr>
        <table>
            <tr><td>商品名</td><td>金額</td></tr>
            <c:forEach items="${sessionScope.sdbAL}" var="sdb">
                <c:set var="total" >${total+sdb.price}</c:set>
                <tr><td> ${sdb.item}</td><td>${sdb.price}円</td></tr>
            </c:forEach>
            <tr><th colspan="2">合計金額：${total}円</th></tr>
        </table>

        <form action="BuyComplete" method="POST">
            <table>
                <tr><td>発送方法</td><td><input type="radio" name="type" value="1" checked="checked">通常発送(夢の中に届きます)<br>
                        <input type="radio" name="type" value="2">爆速発送（心の中に特急で届きます）<br>
                        <input type="radio" name="type" value="3">未来発送（未来で購入したら届きます）</td></tr>
                <tr><td colspan="2">
                        <input type="submit" value="上記の内容で購入する">
                    </td></tr>
            </table>
        </form>

    </body>
</html>
