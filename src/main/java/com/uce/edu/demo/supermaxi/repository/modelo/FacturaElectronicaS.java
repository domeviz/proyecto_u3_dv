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
@Table(name = "factura_electronica_S")
public class FacturaElectronicaS {

	@Id
	@Column(name = "faec_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faec_id_seq")
	@SequenceGenerator(name = "faec_id_seq", sequenceName = "faec_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "faec_numero_factura")
	private String numeroFactura;
	
	@Column(name = "faec_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "faec_monto")
	private BigDecimal monto;

	@Column(name = "faec_codigo")
	private String codigo;
	
	@Column(name = "faec_numero_items")
	private Integer numeroItems;

	@Override
	public String toString() {
		return "FacturaElectronica [id=" + id + ", numeroFactura=" + numeroFactura + ", fecha=" + fecha + ", monto="
				+ monto + ", codigo=" + codigo + ", numeroItems=" + numeroItems + "]";
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}
	
}
