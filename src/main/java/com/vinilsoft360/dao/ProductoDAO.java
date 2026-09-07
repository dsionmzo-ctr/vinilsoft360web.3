package com.vinilsoft360.dao;

import com.vinilsoft360.conexion.Conexion;
import com.vinilsoft360.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de realizar las operaciones CRUD de la tabla producto.
 *
 * @author Dayson Mazo Villa
 */
public class ProductoDAO {

    public boolean agregarProducto(Producto producto) {

        String sql = "INSERT INTO producto(nombre, categoria, descripcion, precio, stock, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setString(6, producto.getEstado());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }

    public List<Producto> listarProductos() {

        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getString("estado"));

                lista.add(producto);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }

    public Producto buscarPorId(int id) {

        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE id_producto=?";

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getString("estado"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }

        return producto;
    }

    public boolean actualizarProducto(Producto producto) {

        String sql = "UPDATE producto SET nombre=?, categoria=?, descripcion=?, precio=?, stock=?, estado=? WHERE id_producto=?";

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setString(6, producto.getEstado());
            ps.setInt(7, producto.getIdProducto());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int id) {

        String sql = "DELETE FROM producto WHERE id_producto=?";

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}