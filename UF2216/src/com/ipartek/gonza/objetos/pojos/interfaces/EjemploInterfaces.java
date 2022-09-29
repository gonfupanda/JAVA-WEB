package com.ipartek.gonza.objetos.pojos.interfaces;

import java.util.ArrayList;
import java.util.List;

public class EjemploInterfaces {

	public static void main(String[] args) {
		List<Rodable> rodables = new ArrayList();
		
		rodables.add(new Balon());
		rodables.add(new Naranja());
		for(Rodable r:rodables) {
			if(r instanceof Comestible) {
					((Comestible) r).comer();
			}
			r.rodar();
			
			if(r instanceof Comestible) {
				Comestible c=(Comestible) r;
				c.comer();
			}
		}

	}
	

}
