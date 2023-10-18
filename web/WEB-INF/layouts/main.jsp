<%-- 
    Document   : main.jsp
    Created on : Oct 7, 2023, 3:59:59 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meet My Lecturer</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <!--header-->
            <div class="row header ">
                <div class="col nounderline ">
                    <a href="<c:url value="/requests/list.do"/>">Requests</a> |
                    <a href="<c:url value="/users/list.do"/>">Users</a> |
                    <a href="<c:url value="/users/logout.do"/>">Logout</a>
                </div>
            </div>
            <!--view-->
            <div class="row content">
                <div class="col">
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>
            </div>
            <!--footer-->
            <div class="row footer">
                <div class="col">
                    Copyright &copy; by FPT Students
                </div>
            </div>
        </div>
    </body>
</html>

