package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial= System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+ Thread.currentThread().getName());
		Cajero cajero1=new Cajero("Domenica", Arrays.asList("Pepito","Juan","Daniel","Pedro"));
		Cajero cajero2=new Cajero("Luis", Arrays.asList("Pepito2","Juan2","Daniel2"));
		Cajero cajero3=new Cajero("Paul", Arrays.asList("Pepito3","Juan3"));
		
		//Un solo Hilo: Proceso Sincrono
		PCCajero gestorAtencion=new PCCajero();
		gestorAtencion.procesar(cajero1);
		
		PCCajero gestorAtencion2=new PCCajero();
		gestorAtencion2.procesar(cajero2);
		
		PCCajero gestorAtencion3=new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		long tiempoFinal= System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido+" seg");
	}

}
