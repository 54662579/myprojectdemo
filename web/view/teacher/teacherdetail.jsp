<%-- 
    Document   : teacherdetail
    Created on : 21-Jun-2018, 10:25:31 AM
    Author     : Dev
--%>
<%@page import="model.teacher.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Teacher Detail</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Teacher Detail</h3>
                <c:set var="tInfo" value="${requestScope.teacherInfo}"/>
                <table border ="2">
                    <tr>
                        <td>Id</td>
                        <td><c:out value="${tInfo.id}"/></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><c:out value="${tInfo.firstName}"/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><c:out value="${tInfo.lastName}"/></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><c:out value="${tInfo.address}"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><c:out value="${tInfo.city}"/></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><c:out value="${tInfo.phoneNumber}"/></td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td><fmt:formatNumber type="currency" value="${tInfo.salary}"/></td>
                    </tr>
                    <tr>
                        <td>Course Taught</td>
                        <td><table border="1">
                                <tr>
                                    <td>Course ID</td>
                                    <td>Course Name</td>
                                    <td colspan="3"></td>
                                </tr>
                                <c:forEach var="c" items="${requestScope.course}">
                                    <tr>
                                        <td><c:out value="${c.id}"/></td>
                                        <td><c:out value="${c.courseName}"/></td>
                                        <td><a href="<%=request.getContextPath()%>/course_detail/${c.id}">Show Course</a></td>
                                        <td><a href="<%=request.getContextPath()%>/edit_course/${c.id}">Edit Course</a></td>
                                        <td><a href="<%=request.getContextPath()%>/teacher_course/?tid=${tInfo.id}&cid=${c.id}" 
                                               onclick="confirm('Are you sure you want to delete?')">Delete Teacher from Course</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </table>
                    <form method="get" action="<%=request.getContextPath()%>/edit_teacher/${tInfo.id}">
                        <button type="submit">Edit</button>
                    </form>
            </div>
        </div>
    </body>
</html>
