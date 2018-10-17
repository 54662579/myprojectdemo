<%-- 
    Document   : studentdetail
    Created on : 18-Jun-2018, 3:51:56 PM
    Author     : Dev
--%>
<%@page import="java.util.List"%>
<%@page import="model.student.Student"%>
<%@page import="model.result.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Student Details</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Student Detail</h3>
                <c:set var="sInfo" value="${requestScope.studentInfo}"/>
                <table border ="2">
                    <tr>
                        <td style="width:30%">Id</td>
                        <td style="width:70%"><c:out value="${sInfo.id}"/></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><c:out value="${sInfo.firstName}"/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><c:out value="${sInfo.lastName}"/></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><c:out value="${sInfo.gender}"/></td>
                    </tr>
                    <tr>
                        <td>Organization</td>
                        <td><c:out value="${sInfo.organisation}"/></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><c:out value="${sInfo.address}"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><c:out value="${sInfo.city}"/></td>
                    </tr>
                    <tr>
                        <td>Province</td>
                        <td><c:out value="${sInfo.province}"/></td>
                    </tr>
                    <tr>
                        <td>Country</td>
                        <td><c:out value="${sInfo.country}"/></td>
                    </tr>
                    <tr>
                        <td>Zip Code</td>
                        <td><c:out value="${sInfo.zipcode}"/></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><c:out value="${sInfo.phoneNumber}"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><c:out value="${sInfo.email}"/></td>
                    </tr>
                    <tr>
                        <td>Major</td>
                        <td><c:out value="${sInfo.major}"/></td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td><c:out value="${sInfo.dateOfBirth}"/></td>
                    </tr>
                    <tr>
                        <td>Course Enrolled</td>
                        <td>
                            <table border="1">
                                <tr>
                                    <td>Course ID</td>
                                    <td>Course Name</td>
                                    <td colspan="3"></td>
                                </tr>
                                <c:forEach var="c" items="${requestScope.course}">
                                    <tr>
                                        <td><c:out value="${c.id}"/></td>
                                        <td><c:out value="${c.courseName}"/></td>  
                                        <td><a href="<%=request.getContextPath()%>/course_detail/${c.id}">Course Detail</a></td> 
                                        <td><a href="<%=request.getContextPath()%>/edit_course/${c.id}">Edit Course</a></td>
                                        <td><a href="<%=request.getContextPath()%>/student_course/?sid=${sInfo.id}&cid=${c.id}" 
                                               onclick="alert('Are you sure you want to delete?')">
                                                Remove Student from Course</a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>Result</td>
                        <td>
                            <table border="2">
                                <tr>
                                    <th>Result ID</th>
                                    <th>Course ID</th>
                                    <th>Course Name</th>
                                    <th>Session Number</th>
                                    <th>Mark</th>
                                    <th colspan="2"></th>
                                </tr>
                                <c:forEach var="r" items="${requestScope.result}">
                                    <tr>
                                        <td><c:out value="${r.id}">null</c:out></td>
                                        <td><c:out value="${r.course.id}">null</c:out></td>
                                        <td><c:out value="${r.course.courseName}">null</c:out></td>
                                        <td><c:out value="${r.sessionNumber}">null</c:out></td>
                                        <td><c:out value="${r.mark}">null</c:out></td>
                                        <td><a href="<%=request.getContextPath()%>/edit_result/${r.id}">Edit Result</a></td>
                                        <td><a href="<%=request.getContextPath()%>/delete_result/${r.id}" 
                                               onclick="confirm('Are you sure you want to delete this result?')">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </table>
                    <form method="get" action="<%=request.getContextPath()%>/edit_student/${sInfo.id}">
                        <button type="submit">Edit</button>
                    </form>
            </div>
        </div>
    </body>
</html>
