package com.uce.edu.demo.supermaxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IProductoSRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

@Service
public class ProductoSServiceImpl implements IProductoSService {

	@Autowired
	private IProductoSRepository iProductoSRepository;

	@Override
	public void insertar(ProductoS producto) {
		// TODO Auto-generated method stub
		this.iProductoSRepository.insertar(producto);
	}

	@Override
	public void actualizar(ProductoS producto) {
		// TODO Auto-generated method stub
		this.iProductoSRepository.actualizar(producto);
	}

	@Override
	public ProductoS buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoSRepository.buscar(codigoBarras);
	}

	
	

}
