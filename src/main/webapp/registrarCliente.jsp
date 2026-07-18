<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="menu.jsp" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Registrar Cliente</title>

    <link rel="stylesheet" type="text/css" href="css/estilos.css">

</head>

<body>

<div class="contenedor">

    <h2>Registrar Cliente</h2>

    <form action="ClienteServlet" method="post">

        <label>Nombre:</label><br>

        <input type="text"
               name="nombre"
               required>

        <br><br>

        <label>Teléfono:</label><br>

        <input type="text"
               name="telefono"
               required>

        <br><br>

        <label>Dirección:</label><br>

        <input type="text"
               name="direccion"
               required>

        <br><br>

        <input class="boton"
               type="submit"
               value="Guardar Cliente">

    </form>

    <br>

    <a class="boton"
       href="listarClientes.jsp">

        📋 Ver Clientes

    </a>

</div>

<%@ include file="footer.jsp" %>

</body>

</html>