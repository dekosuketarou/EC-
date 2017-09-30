<%-- 
    Document   : search
    Created on : 2017/09/26, 22:36:02
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ECsiteLogic.MenuHelper"%>
<%@page import="Data.ShopDataBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%

            ArrayList<ShopDataBeans> searchResult = (ArrayList<ShopDataBeans>) session.getAttribute("searchResult");

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.searchResult!=null}">
                <c:choose>
                    <c:when test="${sessionScope.login!=null}">
                        <%=MenuHelper.getInstance().getLogoutMenu()%>
                        <%=MenuHelper.getInstance().getMyDataMenu()%>
                        <%=MenuHelper.getInstance().getCartMenu()%>
                    </c:when>
                    <c:otherwise> 
                        <form action="Login" method="POST">
                            <input type="hidden" value="search.jsp" name="return">
                            <input type="submit" value="ログインページへ">
                        </form>
                    </c:otherwise>
                </c:choose>
                <hr>
                <h3>検索キーワード「${sessionScope.keyword}」で検索した結果</h3>
                <h3>商品が${hit}件見つかりました</h3>
                <%for (ShopDataBeans sdb : searchResult) {%>
                <table>
                    <tr><td rowspan="2"><img src="<%=sdb.getImageURL()%>" ></td><td><a href="Item?code=<%=sdb.getItemCode()%>"><%=sdb.getItem()%></a></td></tr>
                    <tr><td><%=sdb.getPrice()%>円(税込み)</td></tr>
                </table>
                <%}%>
            </c:when>
            <c:otherwise><%request.getRequestDispatcher("top.jsp").forward(request, response);%></c:otherwise>
        </c:choose>
    </body>
</html>
