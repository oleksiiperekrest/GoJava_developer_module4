<%@ page import="model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%--<%--%>
    <%--String action = request.getAttribute("action").toString();--%>
<%--%>--%>
<c:if test = "${action == 'add'}">

    <h1 style="font-weight: bold;">ADD PRODUCT</h1>
    <form action="/edit_product">
        Name:<br>
        <input type="text" name="name" required>
        <br>
        Price:<br>
        <input type="number" name="price" required>
        <br>
        Manufacturer:<br>
        <select name="manufacturer">
    <%
        List<Manufacturer> manufacturers = (List<Manufacturer> ) request.getAttribute("manufacturers");
        for (Manufacturer manufacturer : manufacturers) {
            out.println("<option value=\"" + manufacturer.getName() + "\">" + manufacturer.getName() + "</option>");
        }
    %>
        </select>
        <br><br>
        <input type="submit" value="Add product">
    </form>
</c:if>

<c:if test = "${action == 'edit'}">

    <h1 style="font-weight: bold;">EDIT PRODUCT</h1>
</c:if>


<%


%>

<div align="left">
    <a style="font-weight: bold; font-family: arial, sans-serif" href="/index">Back to index</a>
</div>