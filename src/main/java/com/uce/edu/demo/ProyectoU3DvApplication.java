package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.factura.repository.modelo.Factura;
import com.uce.edu.demo.factura.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner{

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);
	
	@Autowired
	private IFacturaService iFacturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("INNER JOIN");
		List<Factura> listaF=this.iFacturaService.buscarFacturaInnerJoin("Descuento");
		for(Factura f: listaF) {
			LOG.info("Factura Descuento: "+f.getNumero());
		}
		
		LOG.info("INNER JOIN 2");
		List<Factura> listaF2=this.iFacturaService.buscarFacturaInnerJoin();
		for(Factura f: listaF2) {
			LOG.info("Factura: "+f.getNumero());
		}
		
		LOG.info("LEFT JOIN");
		List<Factura> listaFL=this.iFacturaService.buscarFacturaOuterLeftJoin("Sin Descuento");
		for(Factura f: listaFL) {
			LOG.info("Factura Sin Descuento: "+f.getNumero());
		}
		
		LOG.info("LEFT JOIN 2");
		List<Factura> listaFL2=this.iFacturaService.buscarFacturaOuterLeftJoin();
		for(Factura f: listaFL2) {
			LOG.info("Factura: "+f.getNumero());
		}
		
		LOG.info("RIGHT JOIN");
		List<Factura> listaFR=this.iFacturaService.buscarFacturaOuterRightJoin("Descuento");
		for(Factura f: listaFR) {
			LOG.info("Factura Descuento: "+f.getNumero());
		}
	}

}
