package com.ipartek.formacion.spring.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.pojos.Cliente;
import com.ipartek.formacion.spring.pojos.Empleado;
import com.ipartek.formacion.spring.pojos.Factura;
import com.ipartek.formacion.spring.pojos.Pedido;
import com.ipartek.formacion.spring.repos.EmpleadoRepo;
import com.ipartek.formacion.spring.repos.FacturaRepo;
import com.ipartek.formacion.spring.service.FacturaService;

@Service
public class FacturaRest implements FacturaService {
	
	@Autowired
	private FacturaRepo repoFactura;

	private final Empleado empleado;

	public FacturaRest(EmpleadoRepo repoEmpleado) {
		empleado = repoEmpleado.findById(5L).orElse(null);
	}

	@Override
	public Factura obtenerFactura(Pedido pedido, Cliente cliente) {
		Factura factura = new Factura(pedido);

		factura.setEmpleado(empleado);
		factura.setCliente(cliente);
		factura.setFecha(LocalDate.now());
		factura.setCodigo(obtenerCodigoNuevo(factura.getFecha().getYear()));

		return factura;
	}

	@Override
	public String obtenerCodigoNuevo(int anno) {
		String codigoUltimo = repoFactura.buscarUltimoCodigo(String.valueOf(anno));

		int numeroUltimo = Integer.parseInt(codigoUltimo.split("-")[1]);
		int numeroNuevo = numeroUltimo + 1;

		return String.format("%d-%03d", anno, numeroNuevo);
	}

	@Override
	public Factura guardarFactura(Factura factura) {
		return repoFactura.save(factura);
	}


}
