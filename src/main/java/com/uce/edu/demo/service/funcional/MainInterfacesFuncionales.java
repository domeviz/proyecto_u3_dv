package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3DvApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}
	
	public static void imprimir(String cadena) {
		LOG.info("Imprimir "+cadena);
	}
	public static void guardar(String cadena) {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Domenica 2";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Alison TE 2";
		LOG.info("Supplier Lambda: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo");
		LOG.info("High Order Supplier 1: " + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1234567";
			return valorConsultado;
		});
		LOG.info("High Order Supplier 2: " + valorHO1);

		// JAVA
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Dome").limit(2);
		test.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// JAVA
		LOG.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero));

		// PREDICATE
		// Clases
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Zoologico"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "Zoologico");
		LOG.info("High Order Predicate: " + respuesta);

		//JAVA
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));

		// FUNCTION
		// Clases
		// Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> Integer.parseInt(cadena) - 2;
		LOG.info("Function Lambda 1: " + functionLambda.aplicar("7"));

		IPersonaFunction<Integer, String> functionLambda2 = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambda 2: " + functionLambda2.aplicar("7"));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFinalHO);
		
		//JAVA
		LOG.info("JAVA Function");
		//Conversiones/ cast Empleado -> EmpleadoDTO (Ligero)
		Stream<String> listaCambiada =  listaNumeros.stream().map(numeroLista ->{
			Integer valor = numeroLista +1;
			String cadena = "num: " + valor.toString();
			return cadena;
		} );
		
		//Declarativa: idea/intencion
		listaCambiada.forEach(cadena -> imprimir(cadena));
		
		//Imperativa: paso a paso
//		for(String valor:) {
//			imprimir(valor);
//		}
		
		// UNARY OPERATOR(FUNCTION)
		// Clases
		// Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("sufijo");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambda: " + unaryLambda.aplicar("Domenica "));
	}

}
