package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.factura.repository.modelo.Detalle;
import com.uce.edu.demo.factura.repository.modelo.Factura;
import com.uce.edu.demo.factura.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("RELACIONAMIENTO WHERE");
		List<Factura> listaW=this.iFacturaService.buscarFacturaJoinWhere("Descuento");
		for(Factura f: listaW) {
			LOG.info("Factura Descuento: "+f.getNumero());
			for(Detalle d: f.getDetalles()) {
				LOG.info("Detalle Descuento: Subtotal: "+d.getSubtotal());
			}
		}
		
		LOG.info("JOIN FETCH");
		List<Factura> listaF=this.iFacturaService.buscarFacturaJoinFetch("Sin Descuento");
		for(Factura f: listaF) {
			LOG.info("Factura Sin Descuento: "+f.getNumero());
			for(Detalle d: f.getDetalles()) {
				LOG.info("Detalle Descuento: Cantidad: "+d.getCantidad());
			}
		}

	}

}
