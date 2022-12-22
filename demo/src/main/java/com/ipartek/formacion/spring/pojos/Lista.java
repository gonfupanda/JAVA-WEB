package com.ipartek.formacion.spring.pojos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Lista {
	private Producto prod;
	private int cantidad;
	
	public BigDecimal getTotal() {
		return this.prod.getPrecio().multiply(new BigDecimal(cantidad));
	}
}