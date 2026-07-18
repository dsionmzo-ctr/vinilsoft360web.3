package com.vinilsoft360.servlet;

import com.vinilsoft360.dao.ProductoDAO;
import com.vinilsoft360.model.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet encargado de administrar todas las operaciones
 * del módulo de productos.
 *
 * Funciones:
 * - Registrar productos.
 * - Consultar un producto para editarlo.
 * - Actualizar productos.
 * - Eliminar productos.
 *
 * @author Dayson Mazo Villa
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    /**
     * Procesa las solicitudes GET.
     * Se utiliza para editar y eliminar productos.
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {

            response.sendRedirect("listarProductos.jsp");
            return;

        }

        switch (accion) {

            case "editar":
                editarProducto(request, response);
                break;

            case "eliminar":
                eliminarProducto(request, response);
                break;

            default:
                response.sendRedirect("listarProductos.jsp");
                break;

        }

    }

    /**
     * Procesa las solicitudes POST.
     * Se utiliza para registrar y actualizar productos.
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {

            registrarProducto(request, response);

        } else {

            switch (accion) {

                case "actualizar":
                    actualizarProducto(request, response);
                    break;

                default:
                    registrarProducto(request, response);
                    break;

            }

        }

    }

    /**
     * Registra un nuevo producto en la base de datos.
     */
    private void registrarProducto(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Producto producto = new Producto();

        producto.setNombre(request.getParameter("nombre"));
        producto.setTipoPiso(request.getParameter("tipoPiso"));
        producto.setColor(request.getParameter("color"));
        producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
        producto.setStock(Integer.parseInt(request.getParameter("stock")));

        ProductoDAO dao = new ProductoDAO();

        dao.agregarProducto(producto);

        response.sendRedirect("listarProductos.jsp");

    }

    /**
     * Consulta un producto por su ID y envía la información
     * al formulario de edición.
     */
    private void editarProducto(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductoDAO dao = new ProductoDAO();

        Producto producto = dao.buscarPorId(id);

        request.setAttribute("producto", producto);

        request.getRequestDispatcher("editarProducto.jsp")
                .forward(request, response);

    }

    /**
     * Actualiza la información de un producto.
     */
    private void actualizarProducto(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Producto producto = new Producto();

        producto.setId(Integer.parseInt(request.getParameter("id")));
        producto.setNombre(request.getParameter("nombre"));
        producto.setTipoPiso(request.getParameter("tipoPiso"));
        producto.setColor(request.getParameter("color"));
        producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
        producto.setStock(Integer.parseInt(request.getParameter("stock")));

        ProductoDAO dao = new ProductoDAO();

        dao.actualizarProducto(producto);

        response.sendRedirect("listarProductos.jsp");

    }

    /**
     * Elimina un producto de la base de datos.
     */
    private void eliminarProducto(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductoDAO dao = new ProductoDAO();

        dao.eliminarProducto(id);

        response.sendRedirect("listarProductos.jsp");

    }

}