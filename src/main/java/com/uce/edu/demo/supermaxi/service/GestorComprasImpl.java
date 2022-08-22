package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaSRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFacturaS;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaS;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronicaS;
import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

@Service
public class GestorComprasImpl implements IGestorComprasService {

	@Autowired
	private IFacturaSRepository iFacturaRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Autowired
	private IDetalleFacturaRepository iDetalleFacturaRepository;
	
	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;

	@Override
	public void comprarProductos(String cedula, String numeroFactura, List<String> codigo) {
		// TODO Auto-generated method stub
		ClienteS cliente=this.iClienteRepository.buscarPorCedula(cedula);

		FacturaS f=new FacturaS();
		f.setFecha(LocalDateTime.now());
		f.setNumero(numeroFactura);
		f.setCliente(cliente);
		
		this.iFacturaRepository.crear(f);


		BigDecimal total=new BigDecimal(0);
		Integer cantProductos=0;
		for(String item: codigo) {
			ProductoS p=this.iProductoRepository.buscarProducto(item);

			total=total.add(p.getPrecio());

			DetalleFacturaS detalle=new DetalleFacturaS();
			detalle.setCantidad(1);
			detalle.setSubtotal(p.getPrecio());
			detalle.setFactura(f);
			detalle.setProducto(p);

			this.iDetalleFacturaRepository.insertar(detalle);

			cantProductos++;
			
			Integer cantidad=p.getStock();
			if(cantidad<0) {
				throw new RuntimeException();
			}else {
				int valor=this.iProductoRepository.actualizarStock(item);
				System.out.println("Se actualizo: "+valor);
			}
		}


		f.setTotal(total);
		this.iFacturaRepository.actualizar(f);

		FacturaElectronicaS factE=new FacturaElectronicaS();
		factE.setFecha(LocalDateTime.now());
		factE.setMonto(total);
		factE.setNumeroFactura(numeroFactura);
		factE.setNumeroItems(cantProductos);

		this.iFacturaElectronicaRepository.insertar(factE);
	}
	
}
