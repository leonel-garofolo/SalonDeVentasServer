
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.PerfilespermisosController;
import org.salondeventas.server.modelo.jpa.PerfilespermisosEntity;
import org.salondeventas.server.services.PerfilespermisosService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/perfilespermisos")
public class PerfilespermisosControllerImpl implements PerfilespermisosController{
	
	@Autowired
	protected PerfilespermisosService perfilespermisosService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  perfilespermisosService.insert(entity);
			if(estado){
				return String.valueOf(
					entity.getIdperfiles() + "," +	
					entity.getIdpermisos()	
			    );
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= perfilespermisosService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  perfilespermisosService.delete(entity);
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
	public PerfilespermisosEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			PerfilespermisosEntity producto= perfilespermisosService.load(
				entity.getIdperfiles(),	
				entity.getIdpermisos()	
			);
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
	public List<PerfilespermisosEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<PerfilespermisosEntity> perfilespermisoss=  perfilespermisosService.loadAll();
			if(perfilespermisoss != null){
				return perfilespermisoss;
			}
			return null;
		}else{
			return null;
		}
	}
}
