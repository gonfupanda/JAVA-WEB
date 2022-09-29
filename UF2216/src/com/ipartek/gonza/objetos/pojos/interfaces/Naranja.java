package com.ipartek.gonza.objetos.pojos.interfaces;

public class Naranja extends Fruto implements Rodable,Comestible {
	
	private boolean limpia=true;

	@Override
	public void rodar() {
		System.out.println("Esta rodando la naranja");
		
	}

	@Override
	public void comer() {
		if(limpia) {
			System.out.println("Que rica!");
		}else {
			System.out.println("Puaj esta sucia");
		}
		
	}

}
