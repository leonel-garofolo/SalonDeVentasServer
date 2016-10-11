
package org.salondeventas.server.controlador.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.salondeventas.server.controlador.LineadeventaController;
import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.modelo.jpa.LineadeventaEntityKey;
import org.salondeventas.server.services.LineadeventaService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/lineadeventa")
public class LineadeventaControllerImpl implements LineadeventaController{
	
	@Autowired
	protected LineadeventaService lineadeventaService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, LineadeventaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  lineadeventaService.insert(entity);
			if(estado){
				return String.valueOf(entity.getIdlineadeventa());
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, LineadeventaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= lineadeventaService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, LineadeventaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  lineadeventaService.delete(entity);
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
	public LineadeventaEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, LineadeventaEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
					// Build the composite key
			LineadeventaEntityKey key = new LineadeventaEntityKey( entity.getIdlineadeventa(), entity.getIdproducto(), entity.getIdventa() );
			LineadeventaEntity producto= lineadeventaService.load(key);		
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
	public List<LineadeventaEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<LineadeventaEntity> lineadeventas=  lineadeventaService.loadAll();
			if(lineadeventas != null){
				return lineadeventas;
			}
			return null;
		}else{
			return null;
		}
	}
}
