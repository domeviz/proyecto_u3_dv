package com.uce.edu.demo.service.funcional.tarea33;

public class ApellidoUnaryOperatorImpl implements IApellidoUnaryOperator<String> {

	@Override
	public String agregarApellido(String arg1) {
		// TODO Auto-generated method stub
		String estudiante = arg1.concat(" Vizcarra");
		return estudiante;
	}
	
}
