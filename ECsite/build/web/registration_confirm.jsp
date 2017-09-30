<%-- 
    Document   : registration_confirm
    Created on : 2017/09/26, 22:35:19
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
        <%=MenuHelper.getInstance().getLoginMenu()%>
        <%=MenuHelper.getInstance().getTopMenu()%>
        <hr>
        <table>
            <tr><th>名前</th><td>${sessionScope.registration.name}</td></tr>
            <tr><th>パスワード</th><td>${sessionScope.registration.password}</td></tr>
            <tr><th>メールアドレス</th><td>${sessionScope.registration.mail}</td></tr>
            <tr><th>住所</th><td>${sessionScope.registration.address}</td></tr>
            <tr><td colspan="2">上記内容で登録しますがよろしいでしょうか？</td></tr>
            <tr><td>
                    <form action="RegistrationComplete">
                        <input type="submit" value="登録する">
                    </form></td>
                <td>
                    <form action="registration.jsp">
                        <input type="submit" value="登録画面に戻る">
                    </form></td></tr></table>
    </body>
</html>
