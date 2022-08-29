package com.uce.edu.demo.service.funcional.tarea33;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(ICajaSorpresaSupplier<String> function) {
		return function.descubrirPremio()+ " Se guardo el nombre";
	}

	public void consumirConsumer(IAlcanciaConsumer<Integer> funcion, Integer valor) {
		funcion.guardarDinero(valor);;
	}
	
	public boolean consumirPredicate(IPreguntasPredicate<String> funcion, String valor) {
		return funcion.respuestaCorrecta(valor);
	}
	
	public String consumirFunction(IRucFunction<String, Integer> funcion, Integer valor) {
		return funcion.agregar(valor);
	}
	
	public String consumirUnary(IApellidoUnaryOperator< String> funcion,String valor) {
		return funcion.agregarApellido(valor);
	}
}
