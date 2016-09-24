package org.salondeventas.server.controlador.impl;

import org.glassfish.jersey.server.ResourceConfig;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.salondeventas.server.servicio.impl.UsuarioSeguridadServicio;

public class Application extends ResourceConfig {
    public Application() {
    	 packages("org.salondeventas.server.controlador.impl");        
    }
}