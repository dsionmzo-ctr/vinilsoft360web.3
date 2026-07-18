<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vinilsoft360.dao.ProductoDAO" %>
<%@ page import="com.vinilsoft360.model.Producto" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<br><br>

<a href="index.jsp">
    <input type="button" value="← Volver al menú principal">
</a>
<head>
    <meta charset="UTF-8">
    <title>Listado de Productos</title>
</head>

<body>

<!-- ================================================ -->
<!-- Tabla que muestra todos los productos registrados -->
<!-- ================================================ -->

<h2>Productos Registrados</h2>

<a href="registrarProducto.jsp">Registrar nuevo producto</a>

<br><br>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Tipo de piso</th>
        <th>Color</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>Acciones</th>
    </tr>

<%
    // Crear objeto DAO para consultar los productos
    ProductoDAO dao = new ProductoDAO();

    // Obtener la lista de productos
    List<Producto> lista = dao.listarProductos();

    // Recorrer la lista y mostrar cada producto
    for (Producto p : lista) {
%>

<tr>

    <td><%= p.getId() %></td>

    <td><%= p.getNombre() %></td>

    <td><%= p.getTipoPiso() %></td>

    <td><%= p.getColor() %></td>

    <td>$ <%= p.getPrecio() %></td>

    <td><%= p.getStock() %></td>

    <td>

        <!-- Enlace para editar el producto -->
        <a href="ProductoServlet?accion=editar&id=<%= p.getId() %>">
            Editar
        </a>

        |

        <!-- Enlace para eliminar el producto -->
        <a href="ProductoServlet?accion=eliminar&id=<%= p.getId() %>"
           onclick="return confirm('¿Está seguro de eliminar este producto?');">

            Eliminar

        </a>

    </td>

</tr>

<%
    }
%>

</table>
<%@ include file="footer.jsp" %>
</body>
</html>