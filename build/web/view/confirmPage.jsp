<%-- 
    Document   : confirmPage
    Created on : 15-Jun-2018, 1:53:14 PM
    Author     : Dev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        
        <title>Confirm Page</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
                <div class="row">
            <div class="side">
                <jsp:include page="menutab.jsp" />
            </div>
            <div class="main">
            <h1>Information Saved.</h1>
            </div>
        </div>
    </body>
</html>
