<%-- 
    Document   : registration
    Created on : 2017/09/26, 22:34:57
    Author     : DEKO
--%>

<%@page import="Data.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%UserDataBeans udb = new UserDataBeans();
        boolean flag=false;
        if(session.getAttribute("registration")!=null){
            udb=(UserDataBeans)session.getAttribute("registration");
            flag=true;
        }
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegistrationConfirm" method="post">
        <table width="80%" >
            <tr><th>名前</th><td><input type="text" name="name" value="<%if(flag){%><%=udb.getName()%><%}%>"><%if(flag){if(udb.getName().equals("")){%>未記入です<%}}%></td></tr>
            <tr><th>パスワード</th><td><input type="text" name="passwaord"style="ime-mode:disabled"></td></tr>
            <tr><th>パスワード確認</th><td><input type="text" name="passconfirm"style="ime-mode:disabled"></td></tr>
            <tr><th>メールアドレス</th><td><input type="email" name="mail" value="<%if(flag){%><%=udb.getMail()%><%}%>"><%if(flag){if(udb.getName().equals("")){%>未記入です<%}}%></td></tr>
            <tr><th>住所</th><td><input type="text" name="address" value="<%if(flag){%><%=udb.getAddress()%><%}%>"><%if(flag){if(udb.getName().equals("")){%>未記入です<%}}%></td></tr>
             <tr><th><input type="submit" value="登録確認">
        </form>
             </th><td>
            <form action="FormReset">
            <input type="submit" value="リセット">
            </form>    </td></tr>
        </table>
    </body>
</html>
