package org.main.Entidades;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter


public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 2222;
    private int idDetalleVenta;
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double precioTotal;



    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalleVenta=" + idDetalleVenta +
                ", idVenta=" + idVenta +
                ", idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                ", precioTotal=" + precioTotal +
                '}';
    }

    public DetalleVenta(double precioTotal, int cantidad, int idProducto, int idVenta, int idDetalleVenta) {
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.idDetalleVenta = idDetalleVenta;
    }

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
