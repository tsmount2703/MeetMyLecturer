<%-- 
    Document   : update
    Created on : Oct 19, 2023, 3:02:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Roles Update</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/roles/update_handler.do"/>">
              <div class="mb-3 mt-3">
                <label for="roleID" class="form-label">Role ID:</label>
                <input disabled type="text" class="form-control" id="roleID" placeholder="Role ID" value="${roles.roleID}">
                <input type="hidden" name="roleID" value="${roles.roleID}">
            </div>

            <div class="mb-3">
                <label for="roleName" class="form-label">Role Name:</label>
                <input type="text" class="form-control" id="roleName" placeholder="Role Name" name="roleName" value="${roles.roleName}">
            </div>
           
            <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
    </div>
    <div class="col">
        <img src="<c:url value="/images/hit.gif"/>" alt="">
    </div>
