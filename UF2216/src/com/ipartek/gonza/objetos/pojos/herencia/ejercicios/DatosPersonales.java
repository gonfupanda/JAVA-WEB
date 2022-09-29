package com.ipartek.gonza.objetos.pojos.herencia.ejercicios;

public class DatosPersonales {
		private String nombre;
		private String nombreDueno;
		
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getNombreDueno() {
			return nombreDueno;
		}
		public void setNombreDueno(String nombreDueno) {
			this.nombreDueno = nombreDueno;
		}
		/**
		 * @param nombre
		 * @param nombreDueno
		 */
		public DatosPersonales(String nombre, String nombreDueno) {
			this.nombre = nombre;
			this.nombreDueno = nombreDueno;
		}
		
		
		
		
}
