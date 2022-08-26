package com.uce.edu.demo.supermaxi.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_electronica_s")
public class FacturaElectronicaS {

	@Id
	@Column(name = "fael_s_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_s_id_seq")
	@SequenceGenerator(name = "fael_s_id_seq", sequenceName = "fael_s_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "fael_s_numero_factura")
	private String numeroFactura;
	
	@Column(name = "fael_s_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fael_s_monto")
	private BigDecimal monto;
	
	@Column(name = "fael_s_numero_items")
	private Integer numeroItems;

	@Override
	public String toString() {
		return "FacturaElectronicaS [id=" + id + ", numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", monto="
				+ monto + ", numeroItems=" + numeroItems + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}
	
}
