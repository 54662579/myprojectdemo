<%-- 
    Document   : index
    Created on : 18-Jun-2018, 11:50:41 AM
    Author     : Dev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Menu Page</title>
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="/view/menutab.jsp" /> 
            </div>
            <div class="main">
                Please select the menu...
            </div>
        </div>
    </body>
</html>
