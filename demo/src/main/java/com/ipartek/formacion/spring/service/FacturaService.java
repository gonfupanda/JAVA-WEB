package com.ipartek.formacion.spring.service;

import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.pojos.Factura;
import com.ipartek.formacion.spring.pojos.Pedido;

public interface FacturaService {
	
	Factura obtenerFactura(Pedido pedido, Cliente cliente);
	String obtenerCodigoNuevo(int anno);
	Factura guardarFactura(Factura factura);

}
