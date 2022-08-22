package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

public interface IProductoRepository {
	
	public ProductoS buscarProducto(String codigoBarras);
	public int actualizarStock(String codigoBarras);
}
