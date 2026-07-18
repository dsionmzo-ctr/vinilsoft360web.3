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

    /**
     * Método para registrar un nuevo producto en la base de datos.
     *
     * @param producto Objeto Producto con la información a registrar.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    public boolean agregarProducto(Producto producto) {

        String sql = "INSERT INTO producto(nombre, tipo_piso, color, precio, stock) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipoPiso());
            ps.setString(3, producto.getColor());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al registrar producto: " + e.getMessage());

            return false;

        }

    }

    /**
     * Método para consultar todos los productos registrados.
     *
     * @return Lista de productos.
     */
    public List<Producto> listarProductos() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM producto";

        try {

            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTipoPiso(rs.getString("tipo_piso"));
                producto.setColor(rs.getString("color"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

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
/**
 * Método que busca un producto por su identificador.
 *
 * @param id Identificador del producto.
 * @return Objeto Producto encontrado o null si no existe.
 */
public Producto buscarPorId(int id) {

    Producto producto = null;

    String sql = "SELECT * FROM producto WHERE id=?";

    try {

        Connection con = Conexion.getConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            producto = new Producto();

            producto.setId(rs.getInt("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setTipoPiso(rs.getString("tipo_piso"));
            producto.setColor(rs.getString("color"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setStock(rs.getInt("stock"));

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println("Error al buscar producto: " + e.getMessage());

    }

    return producto;

}
/**
 * Actualiza la información de un producto.
 *
 * @param producto Producto con la información actualizada.
 * @return true si la actualización fue exitosa.
 */
public boolean actualizarProducto(Producto producto) {

    String sql = "UPDATE producto SET nombre=?, tipo_piso=?, color=?, precio=?, stock=? WHERE id=?";

    try {

        Connection con = Conexion.getConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getTipoPiso());
        ps.setString(3, producto.getColor());
        ps.setDouble(4, producto.getPrecio());
        ps.setInt(5, producto.getStock());
        ps.setInt(6, producto.getId());

        ps.executeUpdate();

        ps.close();
        con.close();

        return true;

    } catch (SQLException e) {

        System.out.println("Error al actualizar producto: " + e.getMessage());

        return false;

    }

}

/**
 * Elimina un producto de la base de datos.
 *
 * @param id Identificador del producto.
 * @return true si la eliminación fue exitosa.
 */
public boolean eliminarProducto(int id) {

    String sql = "DELETE FROM producto WHERE id=?";

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