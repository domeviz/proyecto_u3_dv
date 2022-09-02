package com.uce.edu.demo.hilos.paralelo.tarea35;

import java.util.concurrent.TimeUnit;

public class TiempoCorredorParalelo extends Thread {

	private CorredorParalelo corredorParalelo;

	public TiempoCorredorParalelo(CorredorParalelo corredorParalelo) {
		this.corredorParalelo = corredorParalelo;
	}

	@Override
	public void run() {
		this.empezarTiempo(this.corredorParalelo);
	}

	public void empezarTiempo(CorredorParalelo corredor) {

		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo procesado: " + Thread.currentThread().getName());
		System.out.println("Cronometrando corredor: " + corredor.getNombre());
		for (String pista : corredor.getPistas()) {
			this.marcarPista(pista);
		}

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Termino: " + corredor.getNombre() + " en " + tiempoTrans + " seg");

	}

	private void marcarPista(String pista) {
		System.out.println("Llegando a: " + pista);
		try {
			//Logica de negocio
			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}