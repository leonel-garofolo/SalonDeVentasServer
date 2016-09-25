package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.IUsuarioControlador;
import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.salondeventas.server.servicio.IUsuarioServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
public class UsuarioControlador implements IUsuarioControlador{
	
	@Autowired
	protected IUsuarioServicio usuarioServicio;	
	@Autowired
	protected IUsuarioSeguridadServicio usuarioSeguridadServicio;			
			
	@POST
	@Path("/agregar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String agregar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  usuarioServicio.agregar(entity);
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
	public String borrar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  usuarioServicio.borrar(entity);
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
	public UsuarioEntity obtener(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, long id) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			UsuarioEntity producto=  usuarioServicio.obtener(id);
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
	public String actualizar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, UsuarioEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  usuarioServicio.actualizar(entity);
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
	public List<UsuarioEntity> obtenerTodos(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			List<UsuarioEntity> usuarios=  usuarioServicio.obtenerTodos();
			if(usuarios != null){
				return usuarios;
			}
			return null;
		}else{
			return null;
		}
	}
}
