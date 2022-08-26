package com.uce.edu.demo.supermaxi.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_s")
public class FacturaS {

	@Id
	@Column(name = "fact_s_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_s_id_seq")
	@SequenceGenerator(name = "fact_s_id_seq", sequenceName = "fact_s_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "fact_s_fecha")
	private LocalDateTime fecha;

	@Column(name = "fact_s_numero")
	private String numero;
	
	@Column(name="fact_s_total")
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "fact_s_clie_id")
	private ClienteS cliente;

	@OneToMany(mappedBy = "factura", cascade=CascadeType.ALL)
	private List<DetalleFacturaS> detalles;

	@Override
	public String toString() {
		return "FacturaS [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", total=" + total + ", cliente="
				+ cliente + ", detalles=" + detalles + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ClienteS getCliente() {
		return cliente;
	}

	public void setCliente(ClienteS cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFacturaS> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFacturaS> detalles) {
		this.detalles = detalles;
	}

}
