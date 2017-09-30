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
<%
    ArrayList<ShopDataBeans> sdbAL = (ArrayList<ShopDataBeans>) session.getAttribute("sdbAL");
    int price = 0;
%>
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
                            <%for (int i = 0; i < sdbAL.size(); i++) {%>
                            <tr><td rowspan="2"><form action="Remove"><input type="hidden" name="remove" value="<%=i%>"><input type="submit" value="削除"></form></td>
                                <td rowspan="2"><img src="<%=sdbAL.get(i).getImageURL()%>" width="100"></td><td><%=sdbAL.get(i).getItem()%></td></tr>
                            <tr><td><%=sdbAL.get(i).getPrice()%>円(税込み)</td></tr>
                            <%price += sdbAL.get(i).getPrice();}%>
                            <tr><th colspan="2">合計金額は<%=price%>円です</th></tr>
                            <tr><td colspan="2">
                                    <form action="BuyConfirm" method="post">
                                        <input type="hidden" name="price" value="<%=price%>">
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
