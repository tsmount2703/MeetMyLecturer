<%-- 
    Document   : update
    Created on : Oct 19, 2023, 3:02:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Requests Update</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/requests/update_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="ID" class="form-label">ID:</label>
                <input disabled type="text" class="form-control" id="ID" placeholder="ID" value="${requests.ID}">
                <input type="hidden" name="ID" value="${requests.ID}">
            </div>
            
              <div class="mb-3">
                <label for="subjectCode" class="form-label">Subject Code:</label>
                <input type="text" class="form-control" id="subjectCode" placeholder="Subject Code " name="subjectCode" value="${requests.subjectCode}">
            </div>

            <div class="mb-3">
                <label for="day" class="form-label">Day:</label>
                <input type="date" class="form-control" id="day" placeholder="Day " name="day">
            </div>

            <div class="mb-3">
                <label for="start" class="form-label">Start Time:</label>
                <input type="time" class="form-control" id="start" placeholder="Start time" name="start" >
            </div>

            <div class="mb-3">
                <label for="end" class="form-label">End Time:</label>
                <input type="time" class="form-control" id="end" placeholder="End Time" name="end" >
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" placeholder="Description" name="description" value="${requests.description}">
            </div>

            <div class="mb-3">
                <label for="studentID" class="form-label">Student ID:</label>
                <input type="text" class="form-control" id="studentID" placeholder="Student ID" name="studentID" value="${requests.studentID}">
            </div>

            <div class="mb-3">
                <label for="lecturerID" class="form-label">Lecturer ID:</label>
                <input type="text" class="form-control" id="lecturerID" placeholder="Lecturer ID" name="lecturerID" value="${requests.lecturerID}">
            </div>

            <div class="mb-3">
                <label for="status" class="form-label">Status:</label>
                <!--<input type="time" class="form-control" id="end" placeholder="End Time" name="end" >-->
                <select name="status" class="form-control form-control-line" id="status" >
                    <option value="true">Yes</option>
                    <option value="false">No</option> 
                </select>
            </div>


            <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
    </div>
    <div class="col">
        <img src="<c:url value="/images/hit.gif"/>" alt="">
    </div>

