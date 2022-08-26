package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaSService {

	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> listaCodigos);
}
