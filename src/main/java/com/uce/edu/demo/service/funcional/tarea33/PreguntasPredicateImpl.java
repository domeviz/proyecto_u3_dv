package com.uce.edu.demo.service.funcional.tarea33;

public class PreguntasPredicateImpl implements IPreguntasPredicate<String> {

	@Override
	public boolean respuestaCorrecta(String respuesta) {
		// TODO Auto-generated method stub
		if(respuesta.equals("Predicate")) {
			return true;
		} else {
			return false;
		}
	}

	
}
