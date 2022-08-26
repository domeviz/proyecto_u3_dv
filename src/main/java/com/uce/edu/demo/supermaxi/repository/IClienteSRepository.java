package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;

public interface IClienteSRepository {
	
	public void crear(ClienteS c);
	public ClienteS buscar(String cedula);
}
