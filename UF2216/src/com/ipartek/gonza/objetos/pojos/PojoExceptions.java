package com.ipartek.gonza.objetos.pojos;

import java.io.Serializable;

public class PojoExceptions extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID =1L;

	public PojoExceptions() {
		super();
	}

	public PojoExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PojoExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public PojoExceptions(String message) {
		super(message);
	}

	public PojoExceptions(Throwable cause) {
		super(cause);
	}

	
	
}
