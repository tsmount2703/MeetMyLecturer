<%-- 
    Document   : create
    Created on : Oct 17, 2023, 6:18:16 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>Users Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/users/create_handler.do"/>">
            <div class="mb-3 mt-3">
                <label for="userID" class="form-label">ID:</label>
                <input type="text" class="form-control" id="userID" placeholder="User ID" name="userID" value="${users.userID}">
            </div>
            <div class="mb-3">
                <label for="userName" class="form-label">Name:</label>
                <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName" value="${users.userName}">
            </div>
            <div class="mb-3">
                <label for="userEmail" class="form-label">Email:</label>
                <input type="text" class="form-control" id="userEmail" placeholder="User Email" name="userEmail" value="${users.userEmail}">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" value="${users.password}">
            </div>
            <div class="mb-3">
                <label for="roleID" class="form-label">Roles:</label>
                <!--<input type="text" class="form-control" id="roleID" placeholder="Role ID" name="roleID" value="${users.roleID}">-->
                <select name="roleID" id="roleID" class="form-control" >
                    <option value="1">Admin</option>
                    <option value="2">Lecturer</option>
                    <option value="3">Student</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="userStatus" class="form-label">Status:</label>
                <select name="userStatus" class="form-control form-control-line" id="userStatus" >
                    <option value="true">Active</option>
                    <option value="false">Unactive</option> 
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
