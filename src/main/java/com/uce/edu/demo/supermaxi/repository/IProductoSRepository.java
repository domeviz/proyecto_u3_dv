package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

public interface IProductoSRepository {
	
	public void insertar(ProductoS producto);
	
	public void actualizar(ProductoS producto);
	
	public ProductoS buscar(String codigoBarras);
}
