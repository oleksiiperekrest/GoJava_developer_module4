
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Manufacturers</h2>

<%
    List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
    for (Manufacturer manufacturer : manufacturers) {
        String id = manufacturer.getId().toString();
        String name = manufacturer.getName();
        Set<Product> products = manufacturer.getProducts();


        out.println("<span>" + id + ", " + name  + products + "</span>");
//        out.println("<a href=\"/delete-cat?catId=" + strId + "\"> Удалить </a>");
//        out.println("<a style=\"background: red;\" href=\"/edit-cat?catId=" + strId + "\"> Редактировать </a>");

        out.println("</br>");
    }
%>

<a style="font-weight: bold;" href="/index">Back to index</a>