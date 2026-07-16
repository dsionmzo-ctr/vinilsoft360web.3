<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vinilsoft360.dao.ClienteDAO" %>
<%@ page import="com.vinilsoft360.model.Cliente" %>

<%
    ClienteDAO dao = new ClienteDAO();
    List<Cliente> lista = dao.listarClientes();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
</head>
<body>

<h2>Clientes Registrados</h2>

<a href="index.jsp">Volver al Registro</a>

<br><br>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Teléfono</th>
        <th>Dirección</th>
        <th>Acciones</th>
    </tr>

<%
    for (Cliente c : lista) {
%>

    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getNombre() %></td>
        <td><%= c.getTelefono() %></td>
        <td><%= c.getDireccion() %></td>
        <td>
            <a href="ClienteServlet?accion=editar&id=<%= c.getId() %>">
                Editar
            </a>
            |
            <a href="ClienteServlet?accion=eliminar&id=<%= c.getId() %>"
               onclick="return confirm('¿Desea eliminar este cliente?');">
                Eliminar
            </a>
        </td>
    </tr>

<%
    }
%>

</table>

</body>
</html>