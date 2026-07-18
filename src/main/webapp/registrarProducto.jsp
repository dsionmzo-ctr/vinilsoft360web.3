<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Producto</title>
</head>

<body>

<!-- ===================================================== -->
<!-- Formulario para registrar productos de Vinilsoft360   -->
<!-- ===================================================== -->

<h2>Registro de Productos</h2>

<!--
    Este formulario envía la información del producto
    al ProductoServlet utilizando el método POST.
-->
<form action="ProductoServlet" method="post">

    <!-- Campo para el nombre del producto -->
    <label>Nombre del producto:</label><br>
    <input type="text" name="nombre" required><br><br>

    <!-- Campo para el tipo de piso -->
    <label>Tipo de piso:</label><br>
    <input type="text" name="tipoPiso" required><br><br>

    <!-- Campo para el color -->
    <label>Color:</label><br>
    <input type="text" name="color" required><br><br>

    <!-- Campo para el precio -->
    <label>Precio:</label><br>
    <input type="number"
           step="0.01"
           name="precio"
           required><br><br>

    <!-- Campo para el inventario -->
    <label>Cantidad disponible:</label><br>
    <input type="number"
           name="stock"
           required><br><br>

    <!-- Botón para registrar el producto -->
    <input type="submit" value="Guardar Producto">

</form>
<%@ include file="footer.jsp" %>
</body>
</html>