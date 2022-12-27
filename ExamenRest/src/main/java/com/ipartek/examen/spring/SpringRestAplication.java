package com.ipartek.examen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class SpringRestAplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestAplication.class, args);
		log.fine("Aplicacion en ejecucion");
	}

}
