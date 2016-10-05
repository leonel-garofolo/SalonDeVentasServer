package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.IPrecioproductoControlador;
import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.salondeventas.server.servicio.IPrecioproductoServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/precioproducto")
public class PrecioproductoControlador implements IPrecioproductoControlador{
	
	@Autowired
	protected IPrecioproductoServicio precioproductoServicio;	
	@Autowired
	protected IUsuarioSeguridadServicio usuarioSeguridadServicio;			
			
	@POST
	@Path("/agregar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String agregar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PrecioproductoEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  precioproductoServicio.agregar(entity);
			if(estado){
				return MensajesSistema.OPERACION_OK;
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}		
	}
	
	@POST
	@Path("/borrar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PrecioproductoEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  precioproductoServicio.borrar(entity);
			if(estado){
				return MensajesSistema.OPERACION_OK;
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}
	}

	@POST
	@Path("/obtener/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PrecioproductoEntity obtener(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, long id) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			PrecioproductoEntity producto=  precioproductoServicio.obtener(id);
			if(producto != null){
				return producto;
			}
			return null;
		}else{
			return null;
		}
	}

	@POST
	@Path("/actualizar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String actualizar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, PrecioproductoEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  precioproductoServicio.actualizar(entity);
			if(estado){
				return MensajesSistema.OPERACION_OK;
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}
	}

	@POST
	@Path("/obtenertodos/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PrecioproductoEntity> obtenerTodos(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			List<PrecioproductoEntity> precioproductos=  precioproductoServicio.obtenerTodos();
			if(precioproductos != null){
				return precioproductos;
			}
			return null;
		}else{
			return null;
		}
	}
}
