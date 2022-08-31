package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

import com.uce.edu.demo.hilos.stream.CajeroParalelo;
import com.uce.edu.demo.hilos.stream.PCCajeroParalelo;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("Domenica", Arrays.asList("Pepito", "Juan", "Daniel", "Pedro"));
		CajeroParalelo cajero2 = new CajeroParalelo("Luis", Arrays.asList("Pepito2", "Juan2", "Daniel2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Paul", Arrays.asList("Pepito3", "Juan3"));

		CajeroParalelo cajero4 = new CajeroParalelo("Juan", Arrays.asList( "Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Luis", Arrays.asList( "Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Paul", Arrays.asList( "Juan3"));
		
		// Hilos independientes: procesos asincronos

		// Domenica
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start(); // procesar

		// Luis
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start(); // procesar

		// Paul
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start(); // procesar

		// Juan
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();// procesar
		
		// Luiis
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();// procesar
		
		// Paul
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();// procesar
		
		//Se ejecuta muchas veces pero no es recomendablepor el procesamiento de la computadora
//		for(int i=0;i<100000;i++) {
//			PCCajeroParalelo gestorAtencion10000 = new PCCajeroParalelo(cajero6);
//			gestorAtencion10000.start();// procesar
//		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + " seg");
	}

}
