package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("RELACIONAMIENTO WHERE");
		List<Hotel> listaHoteles = this.iHotelService.buscarHotelInnerJoin("Individual");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel Individual: " + h.getNombre() + " " + h.getDireccion());
		}
		
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHotelesI=this.iHotelService.buscarHotelInnerJoin("Individual");
		for(Hotel h: listaHotelesI) {
			LOG.info("Hotel 2 Individual: "+h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Hotel 2 Habitaciones: "+ha);
			}
		}
		
		LOG.info("JOIN FETCH");
		List<Hotel> listaHotelesF=this.iHotelService.buscarHotelJoinFetch("Individual");
		for(Hotel h: listaHotelesF) {
			LOG.info("Hotel 3 Individual: "+h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Hotel 3 Habitaciones: "+ha);
			}
		}

	}

}
