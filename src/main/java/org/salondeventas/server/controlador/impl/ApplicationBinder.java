package org.salondeventas.server.controlador.impl;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.salondeventas.server.servicio.IProductoServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.salondeventas.server.servicio.impl.ProductoServicio;
import org.salondeventas.server.servicio.impl.UsuarioSeguridadServicio;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
    	System.out.println("confiugre bind");
        bind(ProductoServicio.class).to(IProductoServicio.class);
        bind(UsuarioSeguridadServicio.class).to(IUsuarioSeguridadServicio.class);        
    }
}
