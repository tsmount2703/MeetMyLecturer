<%-- 
    Document   : update
    Created on : Oct 19, 2023, 3:02:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Bookings Update</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/bookings/update_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="ID" class="form-label">ID:</label>
                <input disabled type="text" class="form-control" id="ID" placeholder="ID" value="${bookings.ID}">
                <input type="hidden" name="ID" value="${bookings.ID}">
            </div>

            <div class="mb-3">
                <label for="bookingID" class="form-label">Booking ID:</label>
                <input disabled type="text" class="form-control" id="bookingID" placeholder="Booking ID" value="${bookings.bookingID}">
                <input type="hidden" name="bookingID" value="${bookings.bookingID}">
            </div>

            <div class="mb-3">
                <label for="studentID" class="form-label">Student ID:</label>
                <input type="text" class="form-control" id="studentID" placeholder="Student ID" name="studentID" value="${bookings.studentID}">
            </div>
            <div class="mb-3">
                <label for="freeSlotID" class="form-label">Free Slot ID:</label>
                <input type="text" class="form-control" id="freeSlotID" placeholder="Free Slot ID" name="freeSlotID" value="${bookings.freeSlotID}">
            </div>

            <div class="mb-3">
                <label for="status" class="form-label">Status:</label>
                <select name="status" class="form-control form-control-line"  >
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
