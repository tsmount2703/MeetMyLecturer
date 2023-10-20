<%-- 
    Document   : create
    Created on : Oct 19, 2023, 3:02:48 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Free Slots Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/freeSlots/create_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="subjectCode" class="form-label">Subject Code:</label>
                <input type="text" class="form-control" id="subjectCode" placeholder="Subject Code" name="subjectCode" value="${freeSlots.subjectCode}">
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
                <label for="capacity" class="form-label">Capacity:</label>
                <input type="number" step="1" class="form-control" id="capacity" placeholder="Capacity" name="capacity" value="${freeSlots.capacity}">
            </div>

            <div class="mb-3">
                <label for="meetLink" class="form-label">Meet Link:</label>
                <input type="text" class="form-control" id="meetLink" placeholder="Meet Link" name="meetLink" value="${freeSlots.meetLink}">
            </div>

            <div class="mb-3">
                <label for="count" class="form-label">Count:</label>
                <input type="number" step="1" class="form-control" id="count" placeholder="" name="count" value="${freeSlots.count}">
            </div>

            <div class="mb-3">
                <label for="lecturerID" class="form-label">Lecturer ID:</label>
                <input type="text" class="form-control" id="lecturerID" placeholder="Lecturer ID" name="lecturerID" value="${freeSlots.lecturerID}">
            </div>
            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
    </div>

