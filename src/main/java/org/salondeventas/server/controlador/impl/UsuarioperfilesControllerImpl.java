
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.UsuarioperfilesController;
import org.salondeventas.server.modelo.jpa.UsuarioperfilesEntity;
import org.salondeventas.server.services.UsuarioperfilesService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuarioperfiles")
public class UsuarioperfilesControllerImpl implements UsuarioperfilesController{
	
	@Autowired
	protected UsuarioperfilesService usuarioperfilesService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioperfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  usuarioperfilesService.insert(entity);
			if(estado){
				return String.valueOf(
					entity.getIdusuario() + "," +	
					entity.getIdperfil()	
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioperfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= usuarioperfilesService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioperfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  usuarioperfilesService.delete(entity);
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
	public UsuarioperfilesEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioperfilesEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			UsuarioperfilesEntity producto= usuarioperfilesService.load(
				entity.getIdusuario(),	
				entity.getIdperfil()	
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
	public List<UsuarioperfilesEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<UsuarioperfilesEntity> usuarioperfiless=  usuarioperfilesService.loadAll();
			if(usuarioperfiless != null){
				return usuarioperfiless;
			}
			return null;
		}else{
			return null;
		}
	}
}
