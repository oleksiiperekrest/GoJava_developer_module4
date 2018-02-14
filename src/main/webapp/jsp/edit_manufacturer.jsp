<%@ page import="model.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<c:if test = "${mode == 'add'}">

    <h1 style="font-weight: bold;">ADD MANUFACTURER</h1>
    <form action="/add_manufacturer" method="POST">
        Name:
        <br>
        <input type="text" name="name" required>
        <br>
        <br>
        <input type="submit" value="Add manufacturer">
    </form>

</c:if>

<c:if test = "${mode == 'edit'}">

    <h1 style="font-weight: bold;">EDIT PRODUCT</h1>
    <form action="/edit_manufacturer" method="POST">

        <%
            Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturer");
        %>

        Name:
        <br>
        <input type="text" value="<%out.print(manufacturer.getName());%>" name="name" required>
        <br>
        <br>
        <input type="submit" value="Save manufacturer">
    </form>

</c:if>

<div align="left">
    <a style="font-weight: bold; font-family: arial, sans-serif" href="/index">Back to index</a>
</div>