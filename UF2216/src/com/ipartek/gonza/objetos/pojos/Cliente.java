package com.ipartek.gonza.objetos.pojos;

public class Cliente extends Persona {
	
	private String nif;	




	/**
	 * @param id
	 * @param nombre
	 * @param nif
	 */
	public Cliente(Long id, String nombre, String nif) {
		super(id, nombre);
		setNif(nif);
	}
	public Cliente( String nombre, String nif) {
		this(null,nombre,nif);
	}


	public String getNif() {
		return nif;
	}
	

	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getInformacion() {
		return super.getInformacion()+","+getNif();
	}
	
	
}
