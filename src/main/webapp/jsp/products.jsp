<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Products</h2>
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
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
<%
    @SuppressWarnings("unchecked")
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product product : products) {
        String id = product.getId().toString();
        String name = product.getName();
        BigDecimal price = product.getPrice();
        String manufacturerName = product.getManufacturer().getName();

        out.println("<tr>");
        out.println("<td>" + id + "</td>");
        out.println("<td>" + name + "</td>");
        out.println("<td>" + price + "</td>");
        out.println("<td>" + manufacturerName + "</td>");
        out.println("<td> <a href = \"/edit_product?id=" + id +"\">Edit</a></td>");
        out.println("<td> <a href = \"/delete_product?id=" + id +"\">Delete</a></td>");

        out.println("</tr>");
    }
%>
</table>

<div align="right">
    <a style="font-weight: initial; font-family: arial, sans-serif" href="/add_product">Add Product</a>
</div>

<div align="left">
    <a style="font-weight: bold; font-family: arial, sans-serif" href="/index">Back to index</a>
</div>