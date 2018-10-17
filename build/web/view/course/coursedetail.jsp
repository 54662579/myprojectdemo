<%-- 
    Document   : teacherdetail
    Created on : 21-Jun-2018, 10:25:31 AM
    Author     : Dev
--%>
<%@page import="model.course.Course"%>
<%@page import="model.student.Student"%>
<%@page import="model.teacher.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/style.css">
        <title>Course Detail</title>
    </head>
    <body>
        <h1 class="header">Welcome to CGS Grading System</h1>
        <div class="row">
            <div class="side">
                <jsp:include page="../menutab.jsp" />
            </div>
            <div class="main">
                <h3 class="header">Course Detail</h3>
                <c:set var="cInfo" value="${requestScope.courseInfo}"/>
                <table border ="2">
                    <tr>
                        <td>Id</td>
                        <td><c:out value="${cInfo.id}"/></td>
                    </tr>
                    <tr>
                        <td>Course Name</td>
                        <td><c:out value="${cInfo.courseName}"/></td>
                    </tr>
                    <tr>
                        <td>Course Description</td>
                        <td><c:out value="${cInfo.courseDes}"/></td>
                    </tr>
                    <tr>
                        <td>Course Code</td>
                        <td><c:out value="${cInfo.courseCode}"/></td>
                    </tr>
                    <tr>
                        <td>Credit Number</td>
                        <td><c:out value="${cInfo.creditNumber}"/></td>
                    </tr>
                    <tr>
                        <td>Teachers</td>
                        <td>
                            <table border="1">
                                <tr>
                                    <th>Teacher ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th colspan="3"></th>
                                </tr>
                                <c:forEach items="${requestScope.teachers}" var="t">
                                    <tr>
                                        <td><c:out value="${t.id}"/></td>
                                        <td><c:out value="${t.firstName}"/></td>
                                        <td><c:out value="${t.lastName}"/></td>
                                        <td><a href="<%=request.getContextPath()%>/teacher_detail/${t.id}">Detail</a></td>
                                        <td><a href="<%=request.getContextPath()%>/edit_teacher/${t.id}">Edit</a></td>
                                        <td><a href="<%=request.getContextPath()%>/teacher_course/?tid=${t.id}&cid=${cInfo.id}" 
                                               onclick="confirm('Are you sure you want to delete?')">Remove from Course</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>Student</td>
                        <td>
                            <table border="1">
                                <tr>
                                    <th>Student ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th colspan="3"></th>
                                </tr>
                                <c:forEach items="${requestScope.students}" var="s">
                                    <tr>
                                        <td><c:out value="${s.id}"/></td>
                                        <td><c:out value="${s.firstName}"/></td>
                                        <td><c:out value="${s.lastName}"/></td>
                                        <td><a href="<%=request.getContextPath()%>/student_detail/${s.id}">Detail</a></td>
                                        <td><a href="<%=request.getContextPath()%>/edit_student/${s.id}">Edit</a></td>
                                        <td><a href="<%=request.getContextPath()%>/student_course/?sid=${s.id}&cid=${cInfo.id}" 
                                               onclick="confirm('Are you sure you want to delete?')">Remove from Course</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Results
                        </td>
                        <td>
                            <table border="1">
                                <tr>
                                    <td>Result ID</td>
                                    <td>Student ID </td>
                                    <td>Session Number</td>
                                    <td>Mark</td>
                                    <td colspan="2"></td>  
                                </tr>
                                <c:forEach items="${requestScope.results}" var="r">
                                    <tr>
                                        <td><c:out value="${r.id}"/></td>
                                        <td><c:out value="${r.student.id}"/></td>
                                        <td><c:out value="${r.sessionNumber}"/></td>
                                        <td><c:out value="${r.mark}"/></td>
                                        <td><a href="<%=request.getContextPath()%>/edit_result/${r.id}">Edit</a></td>
                                        <td><a href="<%=request.getContextPath()%>/delete_result/${r.id}" 
                                               onclick="confirm('Are you sure you want to delete?')">Remove result</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </table>
                <form method="get" action="<%=request.getContextPath()%>/edit_course/${cInfo.id}">
                    <button type="submit">Edit</button>
                </form>
            </div>
        </div>
    </body>
</html>
