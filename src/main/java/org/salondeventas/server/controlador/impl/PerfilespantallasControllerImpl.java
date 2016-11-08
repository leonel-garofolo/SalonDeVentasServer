
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.PerfilespantallasController;
import org.salondeventas.server.modelo.jpa.PerfilespantallasEntity;
import org.salondeventas.server.services.PerfilespantallasService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/perfilespantallas")
public class PerfilespantallasControllerImpl implements PerfilespantallasController{
	
	@Autowired
	protected PerfilespantallasService perfilespantallasService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespantallasEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  perfilespantallasService.insert(entity);
			if(estado){
				return String.valueOf(
					entity.getIdperfiles() + "," +	
					entity.getIdpantallas()	
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespantallasEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= perfilespantallasService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespantallasEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  perfilespantallasService.delete(entity);
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
	public PerfilespantallasEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PerfilespantallasEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			PerfilespantallasEntity producto= perfilespantallasService.load(
				entity.getIdperfiles(),	
				entity.getIdpantallas()	
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
	public List<PerfilespantallasEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<PerfilespantallasEntity> perfilespantallass=  perfilespantallasService.loadAll();
			if(perfilespantallass != null){
				return perfilespantallass;
			}
			return null;
		}else{
			return null;
		}
	}
}
