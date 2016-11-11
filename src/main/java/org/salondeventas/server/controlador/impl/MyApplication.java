package org.salondeventas.server.controlador.impl;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
	public MyApplication() {
		//Mapping relacion de objetos hibernate
		register(JacksonFeature.class);
		register(MyObjectMapperProvider.class);		
		//Obtener expception en respuestas json del server
		register(ExceptionMapper.class);
		packages("org.salondeventas.server.controlador.impl");
	}	
}