<%-- 
    Document   : confirmdelete
    Created on : 19-Jun-2018, 2:12:56 PM
    Author     : Dev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Confirm Delete</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="menutab.jsp" />
            </div>
            <div class="main">
            <h1>Information Deleted.</h1>
            </div>
        </div>
    </body>
</html>
