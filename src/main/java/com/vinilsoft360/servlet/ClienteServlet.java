package com.vinilsoft360.servlet;

import com.vinilsoft360.dao.ClienteDAO;
import com.vinilsoft360.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

   @Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String accion = request.getParameter("accion");

    Cliente cliente = new Cliente();

    if ("actualizar".equals(accion)) {

        cliente.setId(Integer.parseInt(request.getParameter("id")));
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setTelefono(request.getParameter("telefono"));
        cliente.setDireccion(request.getParameter("direccion"));

        ClienteDAO dao = new ClienteDAO();
        dao.actualizarCliente(cliente);

    } else {

        cliente.setNombre(request.getParameter("nombre"));
        cliente.setTelefono(request.getParameter("telefono"));
        cliente.setDireccion(request.getParameter("direccion"));

        ClienteDAO dao = new ClienteDAO();
        dao.agregarCliente(cliente);
    }

    response.sendRedirect("listarClientes.jsp");
}

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        ClienteDAO dao = new ClienteDAO();

        if ("eliminar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            dao.eliminarCliente(id);
        } else if ("editar".equals(accion)) {

    int id = Integer.parseInt(request.getParameter("id"));

    Cliente cliente = dao.buscarPorId(id);

    request.setAttribute("cliente", cliente);

    request.getRequestDispatcher("editarCliente.jsp")
        .forward(request, response);

    return;
}

        response.sendRedirect("listarClientes.jsp");
    }
}