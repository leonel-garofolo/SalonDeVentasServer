package org.salondeventas.server.controlador.impl;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
    public Application() {
    	 packages("org.salondeventas.server.controlador.impl");        
    }
}