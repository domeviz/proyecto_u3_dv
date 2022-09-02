package com.uce.edu.demo.service.funcional.tarea33;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3DvApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);

	public static boolean validacionNombre(String nombre) {
		return nombre.contains("D");
	}
	
	public static void imprimir(Integer numero) {
		LOG.info("Imprimir "+numero);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// Clases
		ICajaSorpresaSupplier<String> supplierClase = new CajaSorpresaSupplierImpl();
		LOG.info("Supplier Clase ");
		LOG.info("El premio es: " + supplierClase.descubrirPremio());

		// Lambdas
		ICajaSorpresaSupplier<String> supplierLambda = () -> "Casa";
		LOG.info("Supplier Lambda ");
		LOG.info("El premio es: " + supplierLambda.descubrirPremio());

		// Metodos High Order
		String valorHOSupplier = metodosHO.consumirSupplier(() -> "Viaje");
		LOG.info("High Order Supplier ");
		LOG.info("El premio es: " + valorHOSupplier);

		// CONSUMER
		// Clases
		LOG.info("Consumer Clase");
		IAlcanciaConsumer<Integer> consumerClase = new AlcanciaConsumerImpl();
		consumerClase.guardarDinero(20);

		// Lambdas
		LOG.info("Consumer Lambda");
		IAlcanciaConsumer<Integer> consumerLambda = dinero -> System.out.println(dinero);
		consumerLambda.guardarDinero(10);

		// Metodos High Order
		LOG.info("High Order Consumer");
		metodosHO.consumirConsumer(dinero -> System.out.println(dinero), 15);

		// PREDICATE
		// Clases
		IPreguntasPredicate<String> predicateClase = new PreguntasPredicateImpl();
		LOG.info("Predicate Clase: " + predicateClase.respuestaCorrecta("Predicate"));

		// Lambdas
		IPreguntasPredicate<String> predicateLambda = respuesta -> respuesta.contains("Supplier");
		LOG.info("Predicate Lambda: " + predicateLambda.respuestaCorrecta("Predicate"));

		// Metodos High Order
		boolean respuestaHO = metodosHO.consumirPredicate(respuesta -> respuesta.contains("Function"), "Predicate");
		LOG.info("High Order Predicate: " + respuestaHO);

		// FUNCTION
		// Clases
		IRucFunction<String, Integer> functionClase = new RucFunctionImpl();
		LOG.info("Function Clase: " + functionClase.agregar(12345678));

		// Lambdas
		IRucFunction<String, Integer> functionLambda = cedula -> {
			String ruc = cedula + "001";
			return ruc;
		};

		LOG.info("Function Lambda: " + functionLambda.agregar(87654332));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;
		}, 1);
		LOG.info("High Order Functional: " + valorFinalHO);

		// UNARY OPERATOR(FUNCTION)
		// Clases
		IApellidoUnaryOperator<String> unaryClase = new ApellidoUnaryOperatorImpl();
		LOG.info("Unary Operator Clase: " + unaryClase.agregarApellido("Andrea "));
		// Lambdas
		IApellidoUnaryOperator<String> unaryLambda = apellido -> {
			String valorFinal = apellido.concat(" Cabrera");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambda: " + unaryLambda.agregarApellido("Domenica "));

		// Metodos High Order
		String valorFinalUHO = metodosHO.consumirUnary(cade -> {
			String valor = cade.concat(" Cabrera");
			return valor;

		}, "Domenica ");

		LOG.info("High Order Unary Operator : " + valorFinalUHO);

		// Tarea 34

		//HighOrder son metodos de java que reciben interfaces funcionales
		
		// Supplier
		//--Genera un arreglo con un valor definido
		// JAVA
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Boleto").limit(5);
		test.forEach(cadena -> System.out.println(cadena));

		//Toda coleccion tiene un metodo HighOrder en este caso forEach
		
		// Consumer
		//--Recibe cualquier dato pero no retorna nada
		// JAVA
		LOG.info("JAVA Consumer");
		List<String> listaNombres = Arrays.asList("Domenica", "Alison", "Valentina", "Dayana");
		listaNombres.forEach(nombres -> System.out.println(nombres));

		// Predicate
		//--Filtrar informacion
		//--Recibe un argumento y retorna un boolean
		// JAVA
		LOG.info("JAVA Predicate");
		Stream<String> nuevaLista = listaNombres.stream().filter(nombres -> validacionNombre(nombres));
		nuevaLista.forEach(nombres -> System.out.println(nombres));

		// Function
		//--Recibe un dato, lo procesa y devuelve otro
		// JAVA
		LOG.info("JAVA Function");
		// Conversiones/ cast Empleado -> EmpleadoDTO (Ligero)
		LOG.info("JAVA Function");
		List<String> listaCompras=Arrays.asList("Pan","Jamon","Queso");
		Stream<String> listaCambiada=listaCompras.stream().map(item->{
			String valor=item.concat(" Comprado");
			return valor;
		});
		listaCambiada.forEach(valor->System.out.println("Estudiante: "+valor));
	}

}
