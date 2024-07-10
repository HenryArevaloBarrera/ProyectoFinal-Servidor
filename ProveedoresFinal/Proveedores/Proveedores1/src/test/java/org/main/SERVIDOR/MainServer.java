package org.main.SERVIDOR;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {
	public static void main(String[]args) {
		try {
			Registry registro = LocateRegistry.createRegistry(2024);
			registro.rebind("Proveedores", new ServerImplements());
			System.out.println("Servidor en ejecucion");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
