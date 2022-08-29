package com.uce.edu.demo.service.funcional.tarea33;

public class RucFunctionImpl implements IRucFunction<String, Integer> {

	@Override
	public String agregar(Integer cedula) {
		// TODO Auto-generated method stub
		String ruc = cedula + "001";
		return ruc;
	}
	
}
