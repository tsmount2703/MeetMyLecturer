<%-- 
    Document   : create
    Created on : Oct 19, 2023, 3:02:48 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Bookings Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/bookings/create_handler.do"/>">
<!--            <div class="mb-3 mt-3">
                <label for="bookingID" class="form-label">Booking ID:</label>
                <input type="text" class="form-control" id="bookingID" placeholder="Booking ID" name="bookingID" value="${bookings.bookingID}">
            </div>-->
            <div class="mb-3 mt-3">
                <label for="studentID" class="form-label">Student ID:</label>
                <input type="text" class="form-control" id="studentID" placeholder="Student ID" name="studentID" value="${bookings.studentID}">
            </div>

            <div class="mb-3">
                <label for="freeSlotID" class="form-label">Free Slots ID:</label>
                <input type="text" class="form-control" id="freeSlotID" placeholder="Free Slot ID" name="freeSlotID" value="${bookings.freeSlotID}">
            </div>

            <div class="mb-3">
                <label for="status" class="form-label">Status:</label>
                <!--<input type="time" class="form-control" id="end" placeholder="End Time" name="end" >-->
                <select name="status" class="form-control form-control-line" id="status" >
                    <option value="true">Yes</option>
                    <option value="false">No</option> 
                </select>
            </div>
            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
    </div>