package com.uce.edu.demo.supermaxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteSRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;

@Service
public class ClienteSServiceImpl implements IClienteSService {

	@Autowired
	private IClienteSRepository iClienteSRepository;

	@Override
	public void crear(ClienteS c) {
		// TODO Auto-generated method stub
		this.iClienteSRepository.crear(c);
	}

	@Override
	public ClienteS buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.iClienteSRepository.buscar(cedula);
	}
	
	

}
