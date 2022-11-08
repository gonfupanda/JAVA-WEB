package com.ipartek.examenModulo.capas.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public class Libro {

	private Long id;
	private String nombre;
	private String precio;
	private Integer descuento;
	private String autor;
	private String imagen;

	private Map<String, String> errores = new TreeMap<>();

	public Libro() {
	}

	public Libro(String id, String nombre, String precio, String descuento, String autor, String imagen) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
		setAutor(autor);
		setImagen(imagen);
	}

	public Libro(String id, String nombre, String precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id <= 0L) {
			errores.put("id", "El id debe ser mayor o igual que uno");
		}

		this.id = id;
	}

	private void setId(String id) {
		if (id == null) {
			setId((Long) null);
		} else {
			if (id.trim().length() == 0 || id.trim()=="") {
				setId((Long) null);
			} else {
				try {
					setId(Long.parseLong(id));
				} catch (NumberFormatException e) {
					errores.put("id", "El id debe ser numérico");
				}
			}
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == null || autor == "") {
			autor = "anonimo";
		}
		this.autor = autor.trim();
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {

		if (urlValidator(imagen)) {
			this.imagen = imagen;
		} else {
			this.imagen = "http://placeimg.com/320/240/tech?4";
		}

	}

	public void setErrores(Map<String, String> errores) {
		this.errores = errores;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public static boolean urlValidator(String url) {
		/* validación de url */
		try {
			new URL(url).toURI();
			return true;
		} catch (URISyntaxException exception) {
			return false;
		} catch (MalformedURLException exception) {
			return false;
		}
	}

	public float getPrecioFinal() {
		String a = "" + this.descuento;
		float c = Float.parseFloat(this.precio);
		float d = Float.parseFloat(a);
		return c-( c*(float) roundDouble(d/100, 2));

	}

	private static double roundDouble(double d, int places) {

		BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
		bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", errores=" + errores + "]";
	}

}
