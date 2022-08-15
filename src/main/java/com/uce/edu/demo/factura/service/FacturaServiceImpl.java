package com.uce.edu.demo.factura.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.factura.repository.IFacturaRepository;
import com.uce.edu.demo.factura.repository.modelo.Detalle;
import com.uce.edu.demo.factura.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterRightJoin(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinWhere(tipoDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(String tipoDetalle) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinFetch(tipoDetalle);
	}
	
	//Trabajo en Grupo
	@Override
	public Factura consultar(Integer id) {
		return this.iFacturaRepository.consultar(id);
	}
	
	@Override
	public void create(Factura f) {
		this.iFacturaRepository.create(f);
	}

	@Override
	public void update(Factura f) {
		this.iFacturaRepository.update(f);
	}

	@Override
	public void delete(Integer id) {
		this.iFacturaRepository.delete(id);
	}
	
	@Override
	public BigDecimal calcularPrecio(Integer id) {
		Factura f=this.iFacturaRepository.consultar(id);
		List<Detalle> productos=f.getDetalles();
		BigDecimal valorFactura=new BigDecimal(0);
		
		for(Detalle p: productos) {
			BigDecimal cantidad=new BigDecimal(p.getCantidad());
			BigDecimal totalProducto=p.getPrecio().multiply(cantidad);
			valorFactura=valorFactura.add(totalProducto);
		}
		
		return valorFactura;
		
	}

	@Override
	public int cantidad(Integer id) {
		Factura f=this.iFacturaRepository.consultar(id);
		List<Detalle> productos=f.getDetalles();
		int canasta=0;
		
		for(Detalle p: productos) {
			canasta=canasta+p.getCantidad();
		}
		
		return canasta;
	}
	
}
