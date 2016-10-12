package org.salondeventas.server.controlador.impl;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
	public Application() {
		System.out.println("cargo Application");
		//Mapping relacion de objetos hibernate
		register(MyObjectMapperProvider.class);
		//Obtener expception en respuestas json del server
		register(ExceptionMapper.class);
		packages("org.salondeventas.server.controlador.impl");
	}	
}