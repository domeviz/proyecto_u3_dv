package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3DvApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SUPPLIER
		//Clases
		IPersonaSupplier<String> supplier=new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE=new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: "+supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda=() -> "Domenica 2";
		LOG.info("Supplier Lmabda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE=() -> "Alison TE 2";
		LOG.info("Supplier Lmabda: "+supplierLambdaTE.getNombre());
		
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda=cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//PREDICATE
		//Clases
		
		//Lambdas
				
		
		//FUNCTION
		//Clases
		
		//Lambdas
		
		
		//UNARY OPERATOR(FUNCTION)
		//Clases
		
		//Lambdas
		
	}

}
