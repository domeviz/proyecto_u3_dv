package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;

public interface IClienteRepository {
	
	public void crear(ClienteS c);
	public ClienteS buscarPorCedula(String cedula);
}
