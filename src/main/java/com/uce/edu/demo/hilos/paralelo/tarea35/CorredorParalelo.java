package com.uce.edu.demo.hilos.paralelo.tarea35;

import java.util.List;

public class CorredorParalelo {

	private String nombre;
	private List<String> pistas;
	
	public CorredorParalelo(String nombre, List<String> clientes) {
		super();
		this.nombre = nombre;
		this.pistas = clientes;
	}
	
	public CorredorParalelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CorredorParalelo [nombre=" + nombre + ", pistas=" + pistas + "]";
	}

	//GET Y SET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getPistas() {
		return pistas;
	}

	public void setPistas(List<String> pistas) {
		this.pistas = pistas;
	}
	
}
