package com.uce.edu.demo.service.funcional.tarea33;

public class AlcanciaConsumerImpl implements IAlcanciaConsumer<Integer> {

	@Override
	public void guardarDinero(Integer dinero) {
		// TODO Auto-generated method stub
		System.out.println("Se ha guardado $"+dinero);
	}
	
}
