<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Validación de sesión: si no hay usuario logueado, redirige al login
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@ include file="menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vinilsoft360</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>

<div class="contenedor">
    <div class="barra-bienvenida">
        <span>👋 Bienvenido, <strong><%= session.getAttribute("usuario") %></strong></span>
        <a href="LogoutServlet">Cerrar sesión</a>
    </div>

    <a class="boton" href="listarClientes.jsp">
        👥 Módulo de Clientes
    </a>

    <a class="boton" href="listarProductos.jsp">
        📦 Módulo de Productos
    </a>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>