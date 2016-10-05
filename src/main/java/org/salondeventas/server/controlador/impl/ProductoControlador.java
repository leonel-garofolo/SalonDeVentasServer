package org.salondeventas.server.controlador.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.salondeventas.server.controlador.IProductoControlador;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.modelo.jpa.VproductosEntity;
import org.salondeventas.server.servicio.IProductoServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.salondeventas.server.util.MensajesSistema;
import org.salondeventas.server.util.ValidacionesGlobales;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/producto")
public class ProductoControlador implements IProductoControlador{
	
	@Autowired
	protected IProductoServicio productoServicio;	
	@Autowired
	protected IUsuarioSeguridadServicio usuarioSeguridadServicio;			
			
	@POST
	@Path("/agregar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String agregar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean prodInsert=  productoServicio.agregar(entity);
			if(prodInsert ){
				return entity.getIdproducto().toString();
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
	public String borrar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  productoServicio.borrar(entity);
			if(estado){
				return MensajesSistema.OPERACION_OK;
			}
			return MensajesSistema.OPERACION_ERROR;
		}else{
			return MensajesSistema.SERVER_ERROR;
		}
	}

	@GET
	@Path("/obtener/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoEntity obtener(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, @QueryParam("id") long id) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			ProductoEntity producto=  productoServicio.obtener(id);
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
	public String actualizar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			boolean estado=  productoServicio.actualizar(entity);
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
	public List<ProductoEntity> obtenerTodos(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(ValidacionesGlobales.validarUsuario(usuario, clave) && usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			List<ProductoEntity> productos=  productoServicio.obtenerTodos();
			if(productos != null){
				return productos;
			}
			return null;
		}else{
			return null;
		}		
	}	
	
	@POST
	@Path("/obtenertodosjson/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<VproductosEntity> obtenerTodosJson(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(ValidacionesGlobales.validarUsuario(usuario, clave) && usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			List<VproductosEntity> productos=  productoServicio.obtenerTodosVista();
			if(productos != null){
				return productos;				
			}
			return null;
		}else{
			return null;
		}		
	}	
}
