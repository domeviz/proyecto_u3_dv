package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaSService {

	public void procesarFacturaElectronica(String numeroFactura, Integer numeroItems, BigDecimal monto);
}
