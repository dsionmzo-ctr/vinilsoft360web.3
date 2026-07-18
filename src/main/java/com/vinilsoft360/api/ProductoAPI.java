package com.vinilsoft360.api;

import com.google.gson.Gson;
import com.vinilsoft360.dao.ProductoDAO;
import com.vinilsoft360.model.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * =========================================================
 * Clase: ProductoAPI
 *
 * Descripción:
 * API REST encargada de devolver la información de los
 * productos registrados en formato JSON.
 *
 * URL:
 * http://localhost:8080/vinilsoft360web/api/productos
 *
 * Autor:
 * Dayson Mazo Villa
 * =========================================================
 */
@WebServlet("/api/productos")
public class ProductoAPI extends HttpServlet {

    /**
     * Atiende solicitudes GET.
     *
     * Devuelve la lista completa de productos
     * en formato JSON.
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Tipo de respuesta
        response.setContentType("application/json");

        response.setCharacterEncoding("UTF-8");

        // Consultar productos

        ProductoDAO dao = new ProductoDAO();

        List<Producto> lista = dao.listarProductos();

        // Convertir a JSON

        Gson gson = new Gson();

        String json = gson.toJson(lista);

        // Enviar respuesta

        response.getWriter().print(json);

    }

}