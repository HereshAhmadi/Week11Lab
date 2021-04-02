<%-- 
    Document   : forgot
    Created on : Apr 2, 2021, 2:07:06 PM
    Author     : 699785
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password</p>
        <form action="reset" method="post">
            Email Address: <input type="text" name="email_address" value="">
            <input type="hidden" name="action" value="forgotPassword">
            <input type="submit" value="submit">
        </form>
        <p>${message}</p>
    </body>
</html>
