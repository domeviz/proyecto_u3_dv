package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteSRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaSRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoSRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFacturaS;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaS;
import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

@Service
public class FacturaSServiceImpl implements IFacturaSService {

	@Autowired
	private IFacturaSRepository iFacturaSRepository;
	
	@Autowired
	private IClienteSRepository iClienteSRepository;
	
	@Autowired
	private IProductoSRepository iProductoSRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> listaCodigos) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = BigDecimal.ZERO;

		ClienteS c = this.iClienteSRepository.buscar(cedula);

		FacturaS f = new FacturaS();
		f.setCliente(c);
		f.setFecha(LocalDateTime.now());
		f.setNumero(numeroFactura);

		List<DetalleFacturaS> detalles = new ArrayList<>();

		for (String codProd : listaCodigos) {
			DetalleFacturaS d = new DetalleFacturaS();
			d.setCantidad(1);
			d.setFactura(f);
			ProductoS producto = this.iProductoSRepository.buscar(codProd);
			d.setProducto(producto);
			d.setSubtotal(d.getProducto().getPrecio());
			totalPagar.add(d.getSubtotal());
			producto.setStock(producto.getStock() - d.getCantidad());
			this.iProductoSRepository.actualizar(producto);
			detalles.add(d);

		}

		f.setDetalles(detalles);

		this.iFacturaSRepository.crear(f);

		return totalPagar;
	}

}
