<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vinilsoft360</title>
</head>
<body>

<h2>Registro de Clientes</h2>

<form action="ClienteServlet" method="post">

    Nombre:<br>
    <input type="text" name="nombre" required>
    <br><br>

    Teléfono:<br>
    <input type="text" name="telefono">
    <br><br>

    Dirección:<br>
    <input type="text" name="direccion">
    <br><br>

    <input type="submit" value="Guardar Cliente">

</form>

</body>
</html>