package org.main.Entidades;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter


public class Venta implements Serializable {
    private static final long serialVersionUID = 2222;
    private int idVenta;
    private  Date fechaVenta;
    private int idCliente;
    private double total;

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fechaVenta=" + fechaVenta +
                ", idCliente=" + idCliente +
                ", total=" + total +
                '}';
    }

    public Venta(int idVenta, double total, int idCliente, Date fechaVenta) {
        this.idVenta = idVenta;
        this.total = total;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
    }

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
