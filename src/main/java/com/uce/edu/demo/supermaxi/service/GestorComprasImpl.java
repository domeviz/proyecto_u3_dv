package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorComprasImpl implements IGestorComprasService {

	@Autowired
	private IFacturaSService iFacturaSService;

	@Autowired
	private IFacturaElectronicaSService iFacturaElectronicaSService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void comprarProductos(String cedula, String numeroFactura, List<String> listaCodigos) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = this.iFacturaSService.procesarFactura(cedula, numeroFactura, listaCodigos);

		this.iFacturaElectronicaSService.procesarFacturaElectronica(numeroFactura, listaCodigos.size(), totalPagar);
		
	}

}
