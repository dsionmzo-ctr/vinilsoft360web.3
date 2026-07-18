<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.vinilsoft360.model.Cliente" %>
<%@ include file="menu.jsp" %>
<%
Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
</head>
<body>

<h2>Editar Cliente</h2>

<form action="ClienteServlet" method="post">

    <input type="hidden" name="id" value="<%= cliente.getId() %>">

    Nombre:<br>
    <input type="text" name="nombre"
           value="<%= cliente.getNombre() %>" required>

    <br><br>

    Teléfono:<br>
    <input type="text" name="telefono"
           value="<%= cliente.getTelefono() %>">

    <br><br>

    Dirección:<br>
    <input type="text" name="direccion"
           value="<%= cliente.getDireccion() %>">

    <br><br>

    <input type="hidden" name="accion" value="actualizar">

    <input type="submit" value="Actualizar Cliente">

</form>

<br>

<a href="listarClientes.jsp">Cancelar</a>
<%@ include file="footer.jsp" %>
</body>
</html>