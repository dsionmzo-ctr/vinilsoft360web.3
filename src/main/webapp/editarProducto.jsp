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

<h2>Editar Producto</h2>

<form action="ProductoServlet" method="post">

    <input type="hidden" name="accion" value="actualizar">
    <input type="hidden" name="id" value="<%= producto.getIdProducto() %>">

    <label>Nombre del producto:</label><br>
    <input type="text" name="nombre" value="<%= producto.getNombre() %>" required><br><br>

    <label>Categoría:</label><br>
    <input type="text" name="categoria" value="<%= producto.getCategoria() %>"><br><br>

    <label>Descripción:</label><br>
    <textarea name="descripcion" rows="3"><%= producto.getDescripcion() %></textarea><br><br>

    <label>Precio:</label><br>
    <input type="number" step="0.01" name="precio" value="<%= producto.getPrecio() %>" required><br><br>

    <label>Stock:</label><br>
    <input type="number" name="stock" value="<%= producto.getStock() %>" required><br><br>

    <label>Estado:</label><br>
    <select name="estado">
        <option value="Activo" <%= "Activo".equals(producto.getEstado()) ? "selected" : "" %>>Activo</option>
        <option value="Inactivo" <%= "Inactivo".equals(producto.getEstado()) ? "selected" : "" %>>Inactivo</option>
    </select><br><br>

    <input type="submit" value="Actualizar Producto">

</form>

<br>

<a href="listarProductos.jsp">Volver al listado</a>
<%@ include file="footer.jsp" %>
</body>
</html>