<%-- 
    Document   : create
    Created on : Oct 19, 2023, 3:02:48 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Semesters Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/semesters/create_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="semesterID" class="form-label">Semester ID:</label>
                <input type="text" class="form-control" id="semesterID" placeholder="Semester ID" name="semesterID" value="${semesters.semesterID}">
            </div>

            <div class="mb-3">
                <label for="semesterName" class="form-label">Semester Name:</label>
                <input type="text" class="form-control" id="semesterName" placeholder="Semester Name" name="semesterName" value="${semester.semesterName}">
            </div>

            <div class="mb-3">
                <label for="startDay" class="form-label">Start Day:</label>
                <input type="date" class="form-control" id="startDay" placeholder="Date" name="startDay" value="${semesters.startDay}">
            </div>

            <div class="mb-3">
                <label for="endDay" class="form-label">End Day:</label>
                <input type="date" class="form-control" id="endDay" placeholder="End Day" name="endDay" value="${semesters.endDay}">
            </div>
 
            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
    </div>

