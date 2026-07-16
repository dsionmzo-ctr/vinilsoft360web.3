package com.vinilsoft360.dao;

import com.vinilsoft360.conexion.Conexion;
import com.vinilsoft360.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERTAR
    public void agregarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes(nombre, telefono, direccion) VALUES(?,?,?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());

            ps.executeUpdate();

            System.out.println("Cliente agregado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CONSULTAR
    public List<Cliente> listarClientes() {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizarCliente(Cliente cliente) {

        String sql = "UPDATE clientes SET nombre=?, telefono=?, direccion=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getId());

            ps.executeUpdate();

            System.out.println("Cliente actualizado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminarCliente(int id) {

        String sql = "DELETE FROM clientes WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Cliente eliminado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public Cliente buscarPorId(int id) {

    Cliente cliente = null;

    String sql = "SELECT * FROM clientes WHERE id=?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            cliente = new Cliente();

            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setDireccion(rs.getString("direccion"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cliente;
}
}