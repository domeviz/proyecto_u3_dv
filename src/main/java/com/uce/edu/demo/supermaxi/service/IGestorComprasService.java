package com.uce.edu.demo.supermaxi.service;

import java.util.List;

public interface IGestorComprasService {

	public void comprarProductos(String cedula, String numeroFactura, List<String> codigos);
	
}
