<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vinilsoft360.dao.ProductoDAO" %>
<%@ page import="com.vinilsoft360.model.Producto" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Productos</title>
</head>

<body>

<a href="index.jsp">
    <input type="button" value="← Volver al menú principal">
</a>

<h2>Productos Registrados</h2>

<a href="registrarProducto.jsp">Registrar nuevo producto</a>

<br><br>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Categoría</th>
        <th>Descripción</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>

<%
    ProductoDAO dao = new ProductoDAO();
    List<Producto> lista = dao.listarProductos();

    for (Producto p : lista) {
%>

<tr>
    <td><%= p.getIdProducto() %></td>
    <td><%= p.getNombre() %></td>
    <td><%= p.getCategoria() %></td>
    <td><%= p.getDescripcion() %></td>
    <td>$ <%= p.getPrecio() %></td>
    <td><%= p.getStock() %></td>
    <td><%= p.getEstado() %></td>
    <td>
        <a href="ProductoServlet?accion=editar&id=<%= p.getIdProducto() %>">Editar</a>
        |
        <a href="ProductoServlet?accion=eliminar&id=<%= p.getIdProducto() %>"
        onclick="return confirm('¿Está seguro de eliminar este producto?');">Eliminar</a>
    </td>
</tr>

<%
    }
%>

</table>
<%@ include file="footer.jsp" %>
</body>
</html>