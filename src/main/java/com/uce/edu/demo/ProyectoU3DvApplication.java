package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);

	@Autowired
	private IHotelService iHotelService;

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		this.iTransferenciaService.realizarTransferencia("13121212", "32311212", new BigDecimal(10));

	}

}
