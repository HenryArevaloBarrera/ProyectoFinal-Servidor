package org.main.RMI;

import org.main.Entidades.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteInterface extends Remote {
	public void leerArreglo(int[] arreglo) throws Exception;

	public void mostrarArreglo(int[] arreglo) throws Exception;

	public void leerClientes(List<Cliente> clientes) throws Exception;

	public void leerDetalleVentas(List<DetalleVenta> detalleVentas) throws Exception;

	public void leerProductos(List<Producto> productos)throws Exception;

	public void leerProveedores(List<Proveedor> proveedores)throws Exception;

	public void leerTiposProducto(List<TipoProducto> tiposProducto)throws Exception;

	public void leerVentas(List<Venta> ventas)throws Exception;

	public Cliente buscarCliente(int identificacion, List<Cliente> clientes) throws Exception;

	public DetalleVenta buscarDetalleVenta(int identificacion, List<DetalleVenta> detallesVenta) throws Exception;

	public Producto buscarProducto(int identificacion, List<Producto> productos) throws Exception;

	public Proveedor buscarProveedor(int identificacion, List<Proveedor> proveedores) throws Exception;

	public TipoProducto buscarTipoProducto(int identificacion, List<TipoProducto> tiposProducto) throws Exception;

	public Venta buscarVenta(int identificacion, List<Venta> ventas) throws Exception;

	public void leerProducto(Producto producto) throws Exception ;

	public void leerCliente(Cliente cliente) throws Exception ;


}
