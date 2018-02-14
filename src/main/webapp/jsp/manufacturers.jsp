<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Manufacturers</h2>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<table style="width:100%">
    <tr>
        <th>UUID</th>
        <th>Name</th>
        <th>Products</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
<%
    @SuppressWarnings("unchecked")
    List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
    for (Manufacturer manufacturer : manufacturers) {
        String id = manufacturer.getId().toString();
        String name = manufacturer.getName();
        Set<Product> productSet = manufacturer.getProducts();

        out.println("<tr>");
        out.println("<td>" + id + "</td>");
        out.println("<td>" + name + "</td>");
        out.print("<td>");
        for (Product product : productSet) {
            out.print(product.getName());
            out.print("<br>");
        }
        out.println("</td>");

        out.println("<td> <a href = \"/edit_manufacturer?id=" + id +"\">Edit</a></td>");
        out.println("<td> <a href = \"/delete_manufacturer?id=" + id +"\">Delete</a></td>");

        out.println("</tr>");
    }
%>
</table>

<div align="right">
    <a style="font-weight: initial; font-family: arial, sans-serif" href="/add_manufacturer">Add Manufacturer</a>
</div>

<div align="left">
    <a style="font-weight: bold; font-family: arial, sans-serif" href="/index">Back to index</a>
</div>