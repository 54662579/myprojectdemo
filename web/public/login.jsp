<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login Page</title>
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <form class="login" action="j_security_check" method="Post">
            <p>User Name: <input type="text" name="j_username"></p>
            <p>Password: <input type="password" name="j_password"></p>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
