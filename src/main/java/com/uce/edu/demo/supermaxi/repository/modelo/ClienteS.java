package com.uce.edu.demo.supermaxi.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_s")
public class ClienteS {

	@Id
	@Column(name = "clie_s_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_s_id_seq")
	@SequenceGenerator(name = "clie_s_id_seq", sequenceName = "clie_s_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "clie_s_cedula")
	private String cedula;

	@Column(name = "clie_s_numero_tarjeta")
	private String numeroTarjeta;

	@OneToMany(mappedBy = "cliente")
	private List<FacturaS> factura;

	@Override
	public String toString() {
		return "ClienteS [id=" + id + ", cedula=" + cedula + ", numeroTarjeta=" + numeroTarjeta + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public List<FacturaS> getFactura() {
		return factura;
	}

	public void setFactura(List<FacturaS> factura) {
		this.factura = factura;
	}

}
