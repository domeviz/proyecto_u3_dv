package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;
import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;
import com.uce.edu.demo.supermaxi.service.IClienteSService;
import com.uce.edu.demo.supermaxi.service.IGestorComprasService;
import com.uce.edu.demo.supermaxi.service.IProductoSService;

@SpringBootApplication
public class ProyectoU3DvApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU3DvApplication.class);
	
	@Autowired
	private IGestorComprasService iGestorComprasService;
	
	@Autowired
	private IClienteSService iClienteSService;
	
	@Autowired
	private IProductoSService iProductoSService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ClienteS c=new ClienteS();
		c.setCedula("123456789");
		c.setNumeroTarjeta("987654321");
		this.iClienteSService.crear(c);
		
		ProductoS p=new ProductoS();
		p.setNombre("Azucar");
		p.setCodigoBarras("111");
		p.setPrecio(new BigDecimal(2));
		p.setStock(50);
		this.iProductoSService.insertar(p);
		
		ProductoS p2=new ProductoS();
		p2.setNombre("Pan");
		p2.setCodigoBarras("222");
		p2.setPrecio(new BigDecimal(1.9));
		p2.setStock(30);
		this.iProductoSService.insertar(p2);
		
		ProductoS p3=new ProductoS();
		p3.setNombre("Sal");
		p3.setCodigoBarras("333");
		p3.setPrecio(new BigDecimal(1.2));
		p3.setStock(45);
		this.iProductoSService.insertar(p3);
		
		List<String> detalles= new ArrayList<String>();
		detalles.add(p.getCodigoBarras());
		detalles.add(p2.getCodigoBarras());
		detalles.add(p3.getCodigoBarras());

		this.iGestorComprasService.comprarProductos("123456789", "1", detalles);

		LOG.info("Compra realizada");
	}

}
