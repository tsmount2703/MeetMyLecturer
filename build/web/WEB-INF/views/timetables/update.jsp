<%-- 
    Document   : update
    Created on : Oct 19, 2023, 3:02:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Timetables Update</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/timetables/update_handler.do"/>">
                <div class="mb-3 mt-3">
                <label for="subjectCode" class="form-label">Subject Code:</label>
                <input type="text" class="form-control" id="subjectCode" placeholder="Subject Code" name="subjectCode" value="${timetables.subjectCode}">
            </div>
            

            <div class="mb-3">
                <label for="slotID" class="form-label">Slot ID:</label>
                <input type="text" class="form-control" id="slotID" placeholder="Slot ID" name="slotID" value="${timetables.slotID}">
            </div>
            
            <div class="mb-3">
                <label for="lecturerID" class="form-label">Lecturer ID:</label>
                <input type="text" class="form-control" id="lecturerID" placeholder="Lecturer ID" name="lecturerID" value="${timetables.lecturerID}">
            </div>
            
            <div class="mb-3">
                <label for="semesterID" class="form-label">Semester ID:</label>
                <input type="text" class="form-control" id="semesterID" placeholder="Semester ID" name="semesterID" value="${timetables.semesterID}">
            </div>

            <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
    </div>
    <div class="col">
        <img src="<c:url value="/images/hit.gif"/>" alt="">
    </div>

