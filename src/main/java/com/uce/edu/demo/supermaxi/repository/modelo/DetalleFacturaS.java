package com.uce.edu.demo.supermaxi.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_s")
public class DetalleFacturaS {

	@Id
	@Column(name = "deta_s_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_s_id_seq")
	@SequenceGenerator(name = "deta_s_id_seq", sequenceName = "deta_s_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "deta_s_cantidad")
	private Integer cantidad;

	@Column(name = "deta_s_subtotal")
	private BigDecimal subtotal;

	@ManyToOne
	@JoinColumn(name = "deta_s_fact_id")
	private FacturaS factura;

	@ManyToOne
	@JoinColumn(name = "deta_s_prod_id")
	private ProductoS producto;

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public FacturaS getFactura() {
		return factura;
	}

	public void setFactura(FacturaS factura) {
		this.factura = factura;
	}

	public ProductoS getProducto() {
		return producto;
	}

	public void setProducto(ProductoS producto) {
		this.producto = producto;
	}

}
