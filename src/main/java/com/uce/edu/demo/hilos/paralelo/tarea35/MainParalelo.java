package com.uce.edu.demo.hilos.paralelo.tarea35;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Competencia de Obstaculos");
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		CorredorParalelo corredor1 = new CorredorParalelo("Domenica", Arrays.asList("Pista 1", "Pista 2"));
		CorredorParalelo corredor2 = new CorredorParalelo("Alison", Arrays.asList("Pista 1"));
		CorredorParalelo corredor3 = new CorredorParalelo("Fredy",
				Arrays.asList("Pista 1", "Pista 2", "Pista 3", "Pista 4", "Pista 5"));
		CorredorParalelo corredor4 = new CorredorParalelo("Sandra",
				Arrays.asList("Pista 1", "Pista 2", "Pista 3", "Pista 4"));
		CorredorParalelo corredor5 = new CorredorParalelo("Andrea", Arrays.asList("Pista 1", "Pista 2", "Pista 3"));

		// Hilos independientes: procesos asincronos

		// Domenica
		TiempoCorredorParalelo gestorPista1 = new TiempoCorredorParalelo(corredor1);
		gestorPista1.start();

		// Alison
		TiempoCorredorParalelo gestorPista2 = new TiempoCorredorParalelo(corredor2);
		gestorPista2.start();

		// Fredy
		TiempoCorredorParalelo gestorPista3 = new TiempoCorredorParalelo(corredor3);
		gestorPista3.start();

		// Sandra
		TiempoCorredorParalelo gestorPista4 = new TiempoCorredorParalelo(corredor4);
		gestorPista4.start();

		// Andrea
		TiempoCorredorParalelo gestorPista5 = new TiempoCorredorParalelo(corredor5);
		gestorPista5.start();

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + " seg");
	}

}
