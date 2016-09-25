package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.IVentaControlador;
import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.salondeventas.server.servicio.IVentaServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/venta")
public class VentaControlador implements IVentaControlador{
	
	@Autowired
	protected IVentaServicio ventaServicio;	
	@Autowired
	protected IUsuarioSeguridadServicio usuarioSeguridadServicio;			
			
	@POST
	@Path("/agregar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String agregar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, VentaEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  ventaServicio.agregar(entity);
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
	public String borrar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, VentaEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  ventaServicio.borrar(entity);
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
	public VentaEntity obtener(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, long id) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			VentaEntity producto=  ventaServicio.obtener(id);
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
	public String actualizar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, VentaEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  ventaServicio.actualizar(entity);
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
	public List<VentaEntity> obtenerTodos(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			List<VentaEntity> ventas=  ventaServicio.obtenerTodos();
			if(ventas != null){
				return ventas;
			}
			return null;
		}else{
			return null;
		}
	}
}
