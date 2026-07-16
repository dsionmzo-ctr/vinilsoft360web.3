package com.vinilsoft360;

import com.vinilsoft360.conexion.Conexion;
import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        Connection conexion = Conexion.getConexion();

        if (conexion != null) {
            System.out.println("Conexión exitosa");
        } else {
            System.out.println("Error al conectar");
        }

    }
}