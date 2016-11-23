
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.VCantProdVendidosController;
import org.salondeventas.server.modelo.informe.jpa.VCantProdVendidosEntity;
import org.salondeventas.server.services.VCantProdVendidosService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vcantprodvendidos")
public class VCantProdVendidosControllerImpl implements VCantProdVendidosController{
	
	@Autowired
	protected VCantProdVendidosService vCantProdVendidosService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;							

	@POST
	@Path("/load/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VCantProdVendidosEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, VCantProdVendidosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			/*
			VCantProdVendidosEntity producto= vCantProdVendidosService.load(
			);
			if(producto != null){
				return producto;
			}
			*/
			return null;
		}else{
			return null;
		}
	}

	@POST
	@Path("/loadall/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<VCantProdVendidosEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<VCantProdVendidosEntity> vCantProdVendidoss=  vCantProdVendidosService.loadAll();
			if(vCantProdVendidoss != null){
				return vCantProdVendidoss;
			}
			return null;
		}else{
			return null;
		}
	}
}
