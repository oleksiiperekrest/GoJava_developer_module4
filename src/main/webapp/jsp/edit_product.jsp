<%@ page import="model.Manufacturer" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>


<c:if test="${mode == 'add'}">

    <h1 style="font-weight: bold;">ADD PRODUCT</h1>
    <form action="${pageContext.request.contextPath}/add_product" method="POST">
        Name:<br>
        <input type="text" name="name" required>
        <br>
        Price:<br>
        <input type="number" name="price" min="0" step="0.01" required>
        <br>
        Manufacturer:<br>
        <select name="manufacturer">
            <%
                List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
                for (Manufacturer manufacturer : manufacturers) {
                    out.println("<option value=\"" + manufacturer.getName() + "\">" + manufacturer.getName() + "</option>");
                }
            %>
        </select>
        <br><br>
        <input type="submit" value="Add product">
    </form>
</c:if>

<c:if test="${mode == 'edit'}">

    <h1 style="font-weight: bold;">EDIT PRODUCT</h1>
    <form action="${pageContext.request.contextPath}/edit_product" method="POST">

        <%
            Product product = (Product) request.getAttribute("product");
        %>

        Name:<br>
        <input type="text" value="<%out.print(product.getName());%>" name="name" required>
        <br>
        Price:<br>
        <input type="number" value="<%out.print(product.getPrice());%>" name="price" min="0" step="0.01" required>
        <br>
        Manufacturer:<br>
        <select name="manufacturer"> value="<%out.print(product.getManufacturer().getName());%>
            <%
                List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
                for (Manufacturer manufacturer : manufacturers) {
                    out.println("<option value=\"" + manufacturer.getName() + "\">" + manufacturer.getName() + "</option>");
                }
            %>
        </select>
        <br><br>
        <input type="submit" value="Save product">
    </form>

</c:if>


<%


%>

<div align="left">
    <a style="font-weight: bold; font-family: arial, sans-serif" href="${pageContext.request.contextPath}/index">Back to
        index</a>
</div>