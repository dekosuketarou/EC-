<%-- 
    Document   : registration
    Created on : 2017/09/26, 22:34:57
    Author     : DEKO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ECsiteLogic.MenuHelper"%>
<%@page import="Data.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%UserDataBeans udb = new UserDataBeans();
            boolean flag = false;
            if (session.getAttribute("registration") != null) {
                udb = (UserDataBeans) session.getAttribute("registration");
                flag = true;
            }
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.login!=null}">
                <%=MenuHelper.getInstance().getLogoutMenu()%>
                <%=MenuHelper.getInstance().getCartMenu()%>
            </c:when>
            <c:otherwise> 
                <form action="Login" method="POST">
                    <input type="hidden" value="registration.jsp" name="return">
                    <input type="submit" value="ログインページへ">
                </form>
            </c:otherwise>
        </c:choose>
        <hr>
        <form action="RegistrationConfirm" method="post">
            <table width="80%" >
                <tr><th>名前</th><td><input type="text" name="name" value="<%if (flag) {%><%=udb.getName()%><%}%>"><%if (flag) {
                                if (udb.getName().equals("")) {%>未記入です<%}
                                    }%></td></tr>
                <tr><th>パスワード</th><td><input type="text" name="password"><%if (flag) {
                                if (udb.getPassword().equals("")) {%>未記入です<%}
                                    }%></td></tr>
                <tr><th>メールアドレス</th><td><input type="email" name="mail" value="<%if (flag) {%><%=udb.getMail()%><%}%>"><%if (flag) {
                                if (udb.getMail().equals("")) {%>未記入です<%}
                                    }%></td></tr>
                <tr><th>住所</th><td><input type="text" name="address" value="<%if (flag) {%><%=udb.getAddress()%><%}%>"><%if (flag) {
                                if (udb.getAddress().equals("")) {%>未記入です<%}
                                    }%></td></tr>
                <tr><th colspan="2"><input type="submit" value="登録確認">
                    </th>
            </table>
        </form>
        <form action="FormReset">
            <table width="80%" >
                <tr><td><input type="submit" value="リセット">
                </td></tr>
            </table>
        </form>  
    </body>
</html>
