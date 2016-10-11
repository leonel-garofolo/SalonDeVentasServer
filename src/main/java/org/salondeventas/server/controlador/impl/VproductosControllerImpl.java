
package org.salondeventas.server.controlador.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.salondeventas.server.controlador.VproductosController;
import org.salondeventas.server.modelo.jpa.VproductosEntity;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.services.VproductosService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/vproductos")
public class VproductosControllerImpl implements VproductosController{
	
	@Autowired
	protected VproductosService vproductosService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;							

	@POST
	@Path("/loadall/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<VproductosEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<VproductosEntity> productos=  vproductosService.loadAll();
			if(productos != null){
				return productos;
			}
			return null;
		}else{
			return null;
		}
	}
}
