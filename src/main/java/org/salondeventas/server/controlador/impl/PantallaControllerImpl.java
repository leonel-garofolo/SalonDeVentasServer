
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.PantallaController;
import org.salondeventas.server.modelo.jpa.PantallaEntity;
import org.salondeventas.server.services.PantallaService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pantalla")
public class PantallaControllerImpl implements PantallaController{
	
	@Autowired
	protected PantallaService pantallaService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  pantallaService.insert(entity);
			if(estado){
				return String.valueOf(entity.getIdpantalla());
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= pantallaService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  pantallaService.delete(entity);
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
	public PantallaEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
					PantallaEntity producto= pantallaService.load(entity.getIdpantalla());		
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
	public List<PantallaEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<PantallaEntity> pantallas=  pantallaService.loadAll();
			if(pantallas != null){
				return pantallas;
			}
			return null;
		}else{
			return null;
		}
	}
}
