package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

public interface IProductoSService {

	public void insertar(ProductoS producto);

	public void actualizar(ProductoS producto);

	public ProductoS buscar(String codigoBarras);
}
