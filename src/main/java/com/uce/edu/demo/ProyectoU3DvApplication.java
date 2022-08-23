package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.service.IGestorComprasService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);
	
	@Autowired
	private IGestorComprasService iGestorComprasService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

}
