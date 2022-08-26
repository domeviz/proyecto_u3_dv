package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaSRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronicaS;

@Service
public class FacturaElectronicaSServiceImpl implements IFacturaElectronicaSService {

	@Autowired
	private IFacturaElectronicaSRepository iFacturaElectronicaSRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarFacturaElectronica(String numeroFactura, Integer numeroItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronicaS e = new FacturaElectronicaS();
		e.setNumeroFactura(numeroFactura);
		e.setFecha(LocalDateTime.now());
		e.setNumeroItems(numeroItems);;
		e.setMonto(monto);
		
		this.iFacturaElectronicaSRepository.insertar(e);
		throw new RuntimeException();
	}
	
}
