<%-- 
    Document   : reset
    Created on : Mar 30, 2021, 3:49:06 PM
    Author     : 699785
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <c:if test="${uuid != null}">
            <h1>Enter a new Password</h1>
            <form action="reset" method="post">
               <input type="text" name="nPass" value="">
               <input type="hidden" name="action" value="newPassword">
                <input type="submit" value="submit">
            </form>
        </c:if>
            
            
            
        <c:if test="${uuid == null}">
            <h1>Reset Password</h1>
            <p>Please enter your email address to reset your password</p>
            <form action="reset" method="post">
                Email Address: <input type="text" name="email_address" value="">
                 <input type="hidden" name="action" value="forgot">
                <input type="submit" value="submit">
            </form>
        </c:if>
            

    </body>
</html>
