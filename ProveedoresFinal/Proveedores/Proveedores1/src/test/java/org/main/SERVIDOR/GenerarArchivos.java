package org.main.SERVIDOR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.main.Entidades.*;

public class GenerarArchivos {

    // Clase interna que implementa Runnable para manejar la escritura en archivos CSV
    private static class CSVWriter<T> implements Runnable {
        private List<T> list;
        private String archivoDestino;

        public CSVWriter(List<T> list, String archivoDestino) {
            this.list = list;
            this.archivoDestino = archivoDestino;
        }

        @Override
        public void run() {
            File carpeta = new File("Recursos2");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
            File archivo = new File(carpeta, archivoDestino);
            try (FileWriter fileWriter = new FileWriter(archivo, true);
                 BufferedWriter writer = new BufferedWriter(fileWriter)) {

                for (T item : list) {
                    if (item instanceof Cliente) {
                        Cliente cliente = (Cliente) item;
                        writer.append(cliente.getIdCliente() + "")
                                .append(',')
                                .append(cliente.getNombre())
                                .append(',')
                                .append(cliente.getDireccion())
                                .append(',')
                                .append(cliente.getTelefono())
                                .append(',')
                                .append(cliente.getEmail())
                                .append('\n');
                    } else if (item instanceof DetalleVenta) {
                        DetalleVenta detalleVenta = (DetalleVenta) item;
                        writer.append(detalleVenta.getIdDetalleVenta() + "")
                                .append(',')
                                .append(detalleVenta.getIdVenta() + "")
                                .append(',')
                                .append(detalleVenta.getIdProducto() + "")
                                .append(',')
                                .append(detalleVenta.getCantidad() + "")
                                .append(',')
                                .append(detalleVenta.getPrecioTotal() + "")
                                .append('\n');
                    } else if (item instanceof Producto) {
                        Producto producto = (Producto) item;
                        writer.append(producto.getIdProducto() + "")
                                .append(',')
                                .append(producto.getNombre())
                                .append(',')
                                .append(producto.getDescripcion())
                                .append(',')
                                .append(producto.getPrecio() + "")
                                .append(',')
                                .append(producto.getIdProveedor() + "")
                                .append(',')
                                .append(producto.getIdTipoProducto() + "")
                                .append(',')
                                .append(producto.getStock() + "")
                                .append('\n');
                    } else if (item instanceof Proveedor) {
                        Proveedor proveedor = (Proveedor) item;
                        writer.append(proveedor.getIdProveedor() + "")
                                .append(',')
                                .append(proveedor.getNombre())
                                .append(',')
                                .append(proveedor.getDireccion())
                                .append(',')
                                .append(proveedor.getTelefono())
                                .append(',')
                                .append(proveedor.getEmail())
                                .append(',')
                                .append(proveedor.getTipoProveedor())
                                .append('\n');
                    } else if (item instanceof TipoProducto) {
                        TipoProducto tipoProducto = (TipoProducto) item;
                        writer.append(tipoProducto.getIdTipoProducto() + "")
                                .append(',')
                                .append(tipoProducto.getNombre())
                                .append('\n');
                    } else if (item instanceof Venta) {
                        Venta venta = (Venta) item;
                        writer.append(venta.getIdVenta() + "")
                                .append(',')
                                .append(venta.getFechaVenta().toString())
                                .append(',')
                                .append(venta.getIdCliente() + "")
                                .append(',')
                                .append(venta.getTotal() + "")
                                .append('\n');
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generarCSVCliente(List<Cliente> listCliente, String archivoDestino) {
        Thread thread = new Thread(new CSVWriter<>(listCliente, archivoDestino));
        thread.start();
    }

    public static void generarCSVDetalleVenta(List<DetalleVenta> listDetalleVenta, String archivoDestino) {
        Thread thread = new Thread(new CSVWriter<>(listDetalleVenta, archivoDestino));
        thread.start();
    }

    public static void generarCSVProducto(List<Producto> listProducto, String archivoDestino) {
        Thread thread = new Thread(new CSVWriter<>(listProducto, archivoDestino));
        thread.start();
    }

    public static void generarCSVProveedor(List<Proveedor> listProveedor, String archivoDestino) {
        Thread thread = new Thread(new CSVWriter<>(listProveedor, archivoDestino));
        thread.start();
    }

    public static void generarCSVTipoProducto(List<TipoProducto> listTipoProducto, String archivoDestino) {
        Thread thread = new Thread(new CSVWriter<>(listTipoProducto, archivoDestino));
        thread.start();
    }

    public static void generarCSVVenta(List<Venta> listVenta, String archivoDestino) {
        Thread thread = new Thread(new CSVWriter<>(listVenta, archivoDestino));
        thread.start();
    }
}
