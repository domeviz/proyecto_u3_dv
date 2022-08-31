package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {

	public void procesar(Cajero cajero ) {
		System.out.println("Nombre del Hilo procesar: "+ Thread.currentThread().getName());
		System.out.println("Procesando cjaero: "+ cajero.getNombre());
		for(String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
			
	}
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}