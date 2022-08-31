package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class CajeroParalelo {

	private String nombre;
	private List<String> clientes;
	
	public CajeroParalelo(String nombre, List<String> clientes) {
		super();
		this.nombre = nombre;
		this.clientes = clientes;
	}
	
	public CajeroParalelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CajeroParalelo [nombre=" + nombre + ", clientes=" + clientes + "]";
	}

	//GET Y SET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getClientes() {
		return clientes;
	}
	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}
}
