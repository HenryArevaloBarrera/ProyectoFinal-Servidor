package org.main.CLIENTE;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;


import org.main.Entidades.Cliente;
import org.main.RMI.RemoteInterface;

public class MainCliente {
    public static void main(String[] args) {
        try {
            System.out.println("Se ingresarán los datos del arreglo local");
            int[] arregloLocal = {17, 99, 90, 42, 108};

            Registry registroCliente = LocateRegistry.getRegistry("192.168.20.29", 2024);
            System.out.println(registroCliente);
            RemoteInterface rmi = (RemoteInterface) registroCliente.lookup("Ventas");

            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente(1, "Jorge", "Dirección 1", "123456789", "jorge@example.com"));
            clientes.add(new Cliente(2, "Andres", "Dirección 2", "987654321", "andres@example.com"));
            clientes.add(new Cliente(3, "Luis", "Dirección 3", "456789123", "luis@example.com"));
            clientes.add(new Cliente(4, "Ramon", "Dirección 4", "789123456", "ramon@example.com"));

            rmi.leerClientes(clientes);

            System.out.println("Cliente Encontrado");
            System.out.println(rmi.buscarCliente(3, clientes).toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
