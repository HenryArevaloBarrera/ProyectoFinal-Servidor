package org.main.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/proveedor?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static Connection obtenerConexion() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conectado con la base de datos");

        } catch (SQLException e) {
            System.out.println("No se puede conectar con la base de datos");
            e.printStackTrace();
        }
        return connection;
    }
}
