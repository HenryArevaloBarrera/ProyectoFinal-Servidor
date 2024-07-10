package org.main.SERVIDOR;

import org.main.Conexion.Conexion;
import org.main.Entidades.*;

        import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que realiza la conexión a la base de datos y proporciona métodos para obtener listas de objetos
 * llenas con datos de las tablas.
 */
public class TraerDatos {

    // Listas para almacenar objetos de diferentes entidades
    static List<Cliente> clientes = new ArrayList<>();
    static List<Proveedor> proveedores = new ArrayList<>();
    static List<DetalleVenta> detallesVentas = new ArrayList<>();
    static List<Producto> productos = new ArrayList<>();
    static List<TipoProducto> tiposProductos = new ArrayList<>();
    static List<Venta> ventas = new ArrayList<>();


    /**
     * Método para llenar los arreglos con los datos de la base de datos.
     */
    public static void llenarArreglos() {
        // Establecer conexión a la base de datos
        try (Connection connection = Conexion.obtenerConexion()) {
            // Llenar el arreglo de clientes
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM cliente")) {
                while (resultSet.next()) {
                    Cliente cliente = new Cliente(resultSet.getInt("ID_Cliente"),
                            resultSet.getString("Nombre"),
                            resultSet.getString("Direccion"),
                            resultSet.getString("Telefono"),
                            resultSet.getString("CorreoElectronico"));
                    clientes.add(cliente);
                }
            }

            // Llenar el arreglo de proveedores
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM proveedor")) {
                while (resultSet.next()) {
                    Proveedor proveedor = new Proveedor(resultSet.getInt("ID_Proveedor"),
                            resultSet.getString("Nombre"),
                            resultSet.getString("Direccion"),
                            resultSet.getString("Telefono"),
                            resultSet.getString("CorreoElectronico"),
                            resultSet.getString("TipoProveedor"));
                    proveedores.add(proveedor);
                }
            }

            // Repetir el mismo proceso para llenar los arreglos de las otras entidades
            // Llenar el arreglo de detalles de venta
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM detalleventa")) {
                while (resultSet.next()) {
                    DetalleVenta detalleVenta = new DetalleVenta(
                            resultSet.getInt("ID_DetalleVenta"),
                            resultSet.getInt("ID_Venta"),
                            resultSet.getInt("ID_Producto"),
                            resultSet.getInt("Cantidad"),
                            (int) resultSet.getDouble("PrecioUnitario")
                    );
                    detallesVentas.add(detalleVenta);
                }
            }

            // Llenar el arreglo de productos
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM producto")) {
                while (resultSet.next()) {
                    Producto producto = new Producto(
                            resultSet.getInt("ID_Producto"),
                            resultSet.getString("Nombre"),
                            resultSet.getString("Descripcion"),
                            resultSet.getDouble("Precio"),
                            resultSet.getInt("ID_Proveedor"),
                            resultSet.getInt("ID_TipoProducto"),
                            resultSet.getInt("Stock"));
                    productos.add(producto);
                }
            }

            // Llenar el arreglo de tipos de producto
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM tipoproducto")) {
                while (resultSet.next()) {
                    TipoProducto tipoProducto = new TipoProducto(
                            resultSet.getInt("ID_TipoProducto"),
                            resultSet.getString("NombreTipo")
                    );
                    tiposProductos.add(tipoProducto);
                }
            }

            // Llenar el arreglo de ventas
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM venta")) {
                while (resultSet.next()) {
                    Venta venta = new Venta(
                                                resultSet.getInt("ID_Venta"),
                            resultSet.getDouble("Total"),
                                                resultSet.getInt("ID_Cliente"),
                            resultSet.getDate("FechaVenta")
                                        );
                    ventas.add(venta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que retorna la lista de clientes.
     *
     * @return La lista de clientes.
     */
    public List<Cliente> obtenerClientes() {
        llenarArreglos();
        return clientes;
    }

    /**
     * Método que retorna la lista de proveedores.
     *
     * @return La lista de proveedores.
     */
    public static List<Proveedor> obtenerProveedores() {
        llenarArreglos();
        return proveedores;
    }

    /**
     * Método que retorna la lista de detalles de ventas.
     *
     * @return La lista de detalles de ventas.
     */
    public static List<DetalleVenta> obtenerDetallesVentas() {
        llenarArreglos();
        return detallesVentas;
    }

    /**
     * Método que retorna la lista de productos.
     *
     * @return La lista de productos.
     */
    public static List<Producto> obtenerProductos() {
        llenarArreglos();
        return productos;
    }

    /**
     * Método que retorna la lista de tipos de productos.
     *
     * @return La lista de tipos de productos.
     */
    public static List<TipoProducto> obtenerTiposProductos() {
        llenarArreglos();
        return tiposProductos;
    }

    /**
     * Método que retorna la lista de ventas.
     *
     * @return La lista de ventas.
     */
    public static List<Venta> obtenerVentas() {
        llenarArreglos();
        return ventas;
    }
}
