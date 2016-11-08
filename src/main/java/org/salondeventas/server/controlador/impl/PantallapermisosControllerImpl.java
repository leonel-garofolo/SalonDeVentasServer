
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.PantallapermisosController;
import org.salondeventas.server.modelo.jpa.PantallapermisosEntity;
import org.salondeventas.server.services.PantallapermisosService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pantallapermisos")
public class PantallapermisosControllerImpl implements PantallapermisosController{
	
	@Autowired
	protected PantallapermisosService pantallapermisosService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallapermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  pantallapermisosService.insert(entity);
			if(estado){
				return String.valueOf(
					entity.getIdpantalla() + "," +	
					entity.getIdpermiso()	
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallapermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= pantallapermisosService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallapermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  pantallapermisosService.delete(entity);
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
	public PantallapermisosEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PantallapermisosEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			PantallapermisosEntity producto= pantallapermisosService.load(
				entity.getIdpantalla(),	
				entity.getIdpermiso()	
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
	public List<PantallapermisosEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<PantallapermisosEntity> pantallapermisoss=  pantallapermisosService.loadAll();
			if(pantallapermisoss != null){
				return pantallapermisoss;
			}
			return null;
		}else{
			return null;
		}
	}
}
