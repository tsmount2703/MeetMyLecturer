<%-- 
    Document   : update
    Created on : Oct 19, 2023, 3:02:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Subjects Update</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/subjects/update_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="subjectCode" class="form-label">Subject Code:</label>
                <input disabled type="text" class="form-control" id="subjectCode" placeholder="Subject Code" value="${subjects.subjectCode}">
                <input type="hidden" name="subjectCode" value="${subjects.subjectCode}">
            </div>

            <div class="mb-3">
                <label for="subjectName" class="form-label">Subject Name:</label>
                <input type="text" class="form-control" id="subjectName" placeholder="Subject Name" name="subjectName" value="${subjects.subjectName}">
            </div>
          
            <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
    </div>
    <div class="col">
        <img src="<c:url value="/images/hit.gif"/>" alt="">
    </div>

