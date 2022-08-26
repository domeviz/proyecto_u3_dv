package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;

public interface IClienteSService {

	public void crear(ClienteS c);
	public ClienteS buscar(String cedula);
}
