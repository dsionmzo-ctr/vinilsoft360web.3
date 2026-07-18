<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.vinilsoft360.model.Producto"%>
<%@ include file="menu.jsp" %>
<%
    // Obtener el producto enviado desde el servlet
    Producto producto = (Producto) request.getAttribute("producto");
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Editar Producto</title>
</head>

<body>

<!-- ====================================================== -->
<!-- Formulario para actualizar un producto de Vinilsoft360 -->
<!-- ====================================================== -->

<h2>Editar Producto</h2>

<!--
    Este formulario envía la información actualizada
    al ProductoServlet.
-->
<form action="ProductoServlet" method="post">

    <!-- Indica al servlet que se realizará una actualización -->
    <input type="hidden" name="accion" value="actualizar">

    <!-- Identificador del producto -->
    <input type="hidden" name="id" value="<%= producto.getId()%>">

    <!-- Nombre del producto -->
    <label>Nombre del producto:</label><br>
    <input type="text"
           name="nombre"
           value="<%= producto.getNombre()%>"
           required><br><br>

    <!-- Tipo de piso -->
    <label>Tipo de piso:</label><br>
    <input type="text"
           name="tipoPiso"
           value="<%= producto.getTipoPiso()%>"
           required><br><br>

    <!-- Color -->
    <label>Color:</label><br>
    <input type="text"
           name="color"
           value="<%= producto.getColor()%>"
           required><br><br>

    <!-- Precio -->
    <label>Precio:</label><br>
    <input type="number"
           step="0.01"
           name="precio"
           value="<%= producto.getPrecio()%>"
           required><br><br>

    <!-- Cantidad disponible -->
    <label>Stock:</label><br>
    <input type="number"
           name="stock"
           value="<%= producto.getStock()%>"
           required><br><br>

    <!-- Botón para actualizar -->
    <input type="submit" value="Actualizar Producto">

</form>

<br>

<a href="listarProductos.jsp">Volver al listado</a>
<%@ include file="footer.jsp" %>
</body>
</html>