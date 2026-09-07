<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Login - Vinilsoft360</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
    <h2>Iniciar sesión</h2>
    <form action="LoginServlet" method="post">
        Usuario: <input type="text" name="usuario" required><br>
        Contraseña: <input type="password" name="clave" required><br>
        <input type="submit" value="Ingresar">
    </form>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>
