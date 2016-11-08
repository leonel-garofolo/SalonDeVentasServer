
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.PerfilesController;
import org.salondeventas.server.modelo.jpa.PerfilesEntity;
import org.salondeventas.server.services.PerfilesService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/perfiles")
public class PerfilesControllerImpl implements PerfilesController{
	
	@Autowired
	protected PerfilesService perfilesService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  perfilesService.insert(entity);
			if(estado){
				return String.valueOf(entity.getIdperfiles());
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}		
	}

	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= perfilesService.update(entity);
			if(estado){
				return MensajesSistema.OPERACION_OK;
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}
	}
	
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  perfilesService.delete(entity);
			if(estado){
				return MensajesSistema.OPERACION_OK;
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}
	}	

	@POST
	@Path("/load/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PerfilesEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
					PerfilesEntity producto= perfilesService.load(entity.getIdperfiles());		
			if(producto != null){
				return producto;
			}
			return null;
		}else{
			return null;
		}
	}

	@POST
	@Path("/loadall/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PerfilesEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<PerfilesEntity> perfiless=  perfilesService.loadAll();
			if(perfiless != null){
				return perfiless;
			}
			return null;
		}else{
			return null;
		}
	}
}
