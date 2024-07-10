package org.main.SERVIDOR;

import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.main.Entidades.*;
import org.main.RMI.RemoteInterface;

import static org.main.SERVIDOR.GenerarArchivos.*;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface {
	protected ServerImplements() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void leerArreglo(int[] arreglo) throws Exception {
		for(int arr: arreglo) {
			System.out.println(arr);
		}

	}

	@Override
	public void mostrarArreglo(int[] arreglo)  {
		for(int arr: arreglo) {
			System.out.println(arr);
		}
	}
	@Override
	public void leerClientes(List<Cliente> clientes)  {
		System.out.println("Lista de clientes reguistrados");

		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
		// Generar el archivo CSV con los clientes
		String archivoDestino = "clientesRegistrados.csv";
		generarCSVCliente(clientes, archivoDestino);
	}
	@Override
	public  void leerProductos(List<Producto> productos) {
		// TODO Auto-generated method stub
		System.out.println("Lista de productos reguistrados");
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}
		String archivoDestino = "productosRegistrados.csv";
		generarCSVProducto(productos, archivoDestino);
	}
	@Override
	public void leerDetalleVentas(List<DetalleVenta> detalleVentas){
		// TODO Auto-generated method stub
		for (DetalleVenta detalleVenta : detalleVentas) {
			System.out.println(detalleVenta.toString());
		}
		String archivoDestino = "detalleVentasRegistrados.csv";
		generarCSVDetalleVenta(detalleVentas, archivoDestino);
	}



	@Override
	public void leerProveedores(List<Proveedor> proveedores) {
		// TODO Auto-generated method stub
		for (Proveedor proveedor : proveedores) {
			System.out.println(proveedor.toString());
		}
		String archivoDestino = "proveedoresRegistrados.csv";
		generarCSVProveedor(proveedores, archivoDestino);
	}
@Override
public void leerTiposProducto(List<TipoProducto> tiposProducto) {
	// TODO Auto-generated method stub
		for (TipoProducto tipoProducto : tiposProducto) {
			System.out.println(tipoProducto.toString());
		}
	String archivoDestino = "tiposProductoRegistrados.csv";
	generarCSVTipoProducto(tiposProducto, archivoDestino);
	}
@Override
	public void leerVentas(List<Venta> ventas) {
	// TODO Auto-generated method stub
		for (Venta venta : ventas) {
			System.out.println(venta.toString());
		}
	String archivoDestino = "ventasRegistradas.csv";
	generarCSVVenta(ventas, archivoDestino);
	}

	@Override
	public Cliente buscarCliente(int identificacion, List<Cliente> clientes) throws Exception {
		System.out.println(" Busacndo Cliente");
		Cliente clienteEncontrado = null;
		for (Cliente cliente : clientes) {
			if (cliente.getIdCliente()==(identificacion)) {
				clienteEncontrado = cliente;
			}
		}
		if (clienteEncontrado != null) {
			// Generaremos un archivo con los clientes buscados
			String archivoDestino = "clientesEncontrados.csv";
			List<Cliente> clientesEncontrados = new ArrayList<>();
			clientesEncontrados.add(clienteEncontrado);
			generarCSVCliente(clientesEncontrados, archivoDestino);
			return clienteEncontrado;

		}
		return null;
	}

	@Override
	public DetalleVenta buscarDetalleVenta(int identificacion, List<DetalleVenta> detallesVenta) throws Exception {
		DetalleVenta detalleVentaEncontrado = null;
		for (DetalleVenta detalleVenta : detallesVenta) {
			if (detalleVenta.getIdDetalleVenta() == identificacion) {
				detalleVentaEncontrado = detalleVenta;
			}
		}
		if (detalleVentaEncontrado != null) {
			// Generaremos un archivo con los detalles de venta buscados
			String archivoDestino = "detallesVentaEncontrados.csv";
			List<DetalleVenta> detallesVentaEncontrados = new ArrayList<>();
			detallesVentaEncontrados.add(detalleVentaEncontrado);
			GenerarArchivos.generarCSVDetalleVenta(detallesVentaEncontrados, archivoDestino);
			return detalleVentaEncontrado;
		}
		return null;
	}

	@Override
	public Producto buscarProducto(int identificacion, List<Producto> productos) throws Exception {
		Producto productoEncontrado = null;
		for (Producto producto : productos) {
			if (producto.getIdProducto() == identificacion) {
				productoEncontrado = producto;
			}
		}
		if (productoEncontrado != null) {
			// Generaremos un archivo con los productos buscados
			String archivoDestino = "productosEncontrados.csv";
			List<Producto> productosEncontrados = new ArrayList<>();
			productosEncontrados.add(productoEncontrado);
			GenerarArchivos.generarCSVProducto(productosEncontrados, archivoDestino);
			return productoEncontrado;
		}
		return null;
	}


	@Override
	public Proveedor buscarProveedor(int identificacion, List<Proveedor> proveedores) throws Exception {
		Proveedor proveedorEncontrado = null;
		for (Proveedor proveedor : proveedores) {
			if (proveedor.getIdProveedor() == identificacion) {
				proveedorEncontrado = proveedor;
			}
		}
		if (proveedorEncontrado != null) {
			// Generaremos un archivo con los proveedores buscados
			String archivoDestino = "proveedoresEncontrados.csv";
			List<Proveedor> proveedoresEncontrados = new ArrayList<>();
			proveedoresEncontrados.add(proveedorEncontrado);
			GenerarArchivos.generarCSVProveedor(proveedoresEncontrados, archivoDestino);
			return proveedorEncontrado;
		}
		return null;
	}


	@Override
	public TipoProducto buscarTipoProducto(int identificacion, List<TipoProducto> tiposProducto) throws Exception {
		TipoProducto tipoProductoEncontrado = null;
		for (TipoProducto tipoProducto : tiposProducto) {
			if (tipoProducto.getIdTipoProducto() == identificacion) {
				tipoProductoEncontrado = tipoProducto;
			}
		}
		if (tipoProductoEncontrado != null) {
			// Generaremos un archivo con los tipos de producto buscados
			String archivoDestino = "tiposProductoEncontrados.csv";
			List<TipoProducto> tiposProductoEncontrados = new ArrayList<>();
			tiposProductoEncontrados.add(tipoProductoEncontrado);
			GenerarArchivos.generarCSVTipoProducto(tiposProductoEncontrados, archivoDestino);
			return tipoProductoEncontrado;
		}
		return null;
	}

	@Override
	public Venta buscarVenta(int identificacion, List<Venta> ventas) throws Exception {
		Venta ventaEncontrada = null;
		for (Venta venta : ventas) {
			if (venta.getIdVenta() == identificacion) {
				ventaEncontrada = venta;
			}
		}
		if (ventaEncontrada != null) {
			// Generaremos un archivo con las ventas buscadas
			String archivoDestino = "ventasEncontradas.csv";
			List<Venta> ventasEncontradas = new ArrayList<>();
			ventasEncontradas.add(ventaEncontrada);
			GenerarArchivos.generarCSVVenta(ventasEncontradas, archivoDestino);
			return ventaEncontrada;
		}
		return null;
	}
 	@Override
	public void leerProducto(Producto producto) {
		String csvFilePath = "Recursos/productos.csv";
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		boolean productoExiste = false;

		try {
			File file = new File(csvFilePath);
			boolean isNewFile = !file.exists();

			// Verificar si el producto ya existe en el archivo
			if (!isNewFile) {
				bufferedReader = new BufferedReader(new FileReader(csvFilePath));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					String[] fields = line.split(",");
					if (fields.length > 0 && Integer.parseInt(fields[0]) == producto.getIdProducto()) {
						productoExiste = true;
						break;
					}
				}
				bufferedReader.close();
			}

			if (productoExiste) {
				System.out.println("El producto con ID " + producto.getIdProducto() + " ya está registrado.");
				return;
			}

			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);

			// Si el archivo es nuevo, escribe los encabezados
			if (isNewFile) {
				printWriter.println("ID Producto,Nombre,Descripcion,Precio,ID Proveedor,ID Tipo Producto,Stock");
			}

			// Escribe la información del producto
			printWriter.println(producto.getIdProducto() + "," +
					producto.getNombre() + "," +
					producto.getDescripcion() + "," +
					producto.getPrecio() + "," +
					producto.getIdProveedor() + "," +
					producto.getIdTipoProducto() + "," +
					producto.getStock());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void leerCliente(Cliente cliente) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		boolean clienteExiste = false;

		try {
			File file = new File("Recursos/clientes.csv");
			boolean isNewFile = !file.exists();

			// Verificar si el cliente ya existe en el archivo
			if (!isNewFile) {
				bufferedReader = new BufferedReader(new FileReader("Recursos/clientes.csv"));
				String line;

				// Saltar la primera línea si es un encabezado
				boolean isFirstLine = true;

				while ((line = bufferedReader.readLine()) != null) {
					if (isFirstLine) {
						isFirstLine = false;
						continue;
					}

					String[] fields = line.split(",");
					if (fields.length > 0 && Integer.parseInt(fields[0]) == cliente.getIdCliente()) {
						clienteExiste = true;
						break;
					}
				}
				bufferedReader.close();
			}

			if (clienteExiste) {
				System.out.println("El cliente con ID " + cliente.getIdCliente() + " ya está registrado.");
				return;
			}

			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);

			// Si el archivo es nuevo, escribe los encabezados
			if (isNewFile) {
				printWriter.println("ID Cliente,Nombre,Direccion,Telefono,Email");
			}

			// Escribe la información del cliente
			printWriter.println(cliente.getIdCliente() + "," +
					cliente.getNombre() + "," +
					cliente.getDireccion() + "," +
					cliente.getTelefono() + "," +
					cliente.getEmail());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
