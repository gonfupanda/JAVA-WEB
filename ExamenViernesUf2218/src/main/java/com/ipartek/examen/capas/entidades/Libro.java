package com.ipartek.examen.capas.entidades;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class Libro {

	private Long id;
	private String nombre;
	private String precio;
	private Integer descuento;

	private Map<String, String> errores = new TreeMap<>();

	public Libro(String id, String nombre, String precio, String descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null) {
			this.id = id;
		}

	}

	public void setId(String id) {
		if (id == "" || id == null) {
			errores.put("id", "El id esta vacio");
		} else {
			this.id = Long.parseLong(id);
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 5) {
			errores.put("nombre", "El producto tiene que tener un nombre de 5 caracteres o más");
		}

		this.nombre = nombre.trim();
	}

	public String getPrecio() {
		return precio;
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "El precio debe ser un número con decimales");
		}
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(new BigDecimal("0.01")) < 0) {
			errores.put("precio", "El precio debe ser 0.01 o más");
		}

		this.precio = "" + precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if (descuento == null || descuento < 0) {
			errores.put("cantidad", "La cantidad debe ser 0 o más");
		} else {
			this.descuento = descuento;
		}

	}

	public void setDescuento(String descuento) {

		if (descuento == "" || descuento == null) {
			errores.put("cantidad", "El campo esta vacio");
		} else {
			Integer a = Integer.parseInt(descuento);
			if (a < 0 || a > 100) {
				errores.put("cantidad", "La cantidad debe ser 0 o más");
			} else {
				this.descuento = a;
			}
		}

	}

	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", errores=" + errores + "]";
	}

}
