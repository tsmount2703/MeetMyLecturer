<%-- 
    Document   : create
    Created on : Oct 19, 2023, 3:02:48 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Slots Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/slots/create_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="slotID" class="form-label">Slot ID:</label>
                <input type="text" class="form-control" id="slotID" placeholder="Slot ID" name="slotID" value="${slots.slotID}">
            </div>
            
            <div class="mb-3">
                <label for="day1" class="form-label">Day 1:</label>
                <input type="text" class="form-control" id="day1" placeholder="Day 1 " name="day1" value="${slots.day1}">
            </div>
            
               <div class="mb-3">
                <label for="day2" class="form-label">Day 2:</label>
                <input type="text" class="form-control" id="day2" placeholder="Day 2 " name="day2" value="${slots.day2}">
            </div>

            <div class="mb-3">
                <label for="startTime" class="form-label">Start Time:</label>
                <input type="time" class="form-control" id="startTime" placeholder="Start time" name="startTime" value="${slots.startTime}" >
            </div>

            <div class="mb-3">
                <label for="endTime" class="form-label">End Time:</label>
                <input type="time" class="form-control" id="endTime" placeholder="End time" name="endTime" value="${slots.endTime}" >
            </div>

            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
    </div>

