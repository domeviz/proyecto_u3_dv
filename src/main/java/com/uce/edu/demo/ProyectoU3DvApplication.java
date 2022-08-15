package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.ContadorHabitaciones;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("Trabajo Grupal");
		
		LOG.info("Programación Avanzada - Grupo 2");

//		ContadorHabitaciones c=this.hotelService.contarHabitaciones(1, "Individual");
//        LOG.info(c);
	}

}
