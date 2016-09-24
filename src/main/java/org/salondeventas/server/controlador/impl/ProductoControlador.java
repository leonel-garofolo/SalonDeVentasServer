package org.salondeventas.server.controlador.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.salondeventas.server.controlador.IProductoControlador;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.servicio.IProductoServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/producto")
public class ProductoControlador implements IProductoControlador{
	
	@Autowired
    private Validator validator;
	 
	@Autowired 
	private IProductoServicio productoServicio;	
	@Autowired
	private IUsuarioSeguridadServicio usuarioSeguridadServicio;	
	
	

	public void setUsuarioSeguridadServicio(IUsuarioSeguridadServicio usuarioSeguridadServicio) {
		this.usuarioSeguridadServicio = usuarioSeguridadServicio;
	}

	@POST
	@Path("/agregar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean agregar(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoEntity entity) {		
		System.out.println("Entro al server");
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			Set<ConstraintViolation<ProductoEntity>> errorValidacion = validator.validate(entity);
			
			return productoServicio.agregar(entity);
		}else{
			return false;
		}		
	}
	
	@GET
	@Path("/get/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {	
		System.out.println("Entro");
		if(usuarioSeguridadServicio.comprobarUsuario("leonel", "123")){
			return "anduvo";
		}else{
			return "no anduvo";
		}		
	}
	
	@POST
	@Path("/borrar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean borrar(@PathParam("usuario") String usuario, @PathParam("clave") String clave, ProductoEntity entity) {
		System.out.println("Borrar...");
		// TODO Auto-generated method stub
		return false;
	}

	@POST
	@Path("/obtener/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoEntity obtener(@PathParam("usuario") String usuario, @PathParam("clave") String clave, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/actualizar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizar(@PathParam("usuario") String usuario, @PathParam("clave") String clave, ProductoEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@POST
	@Path("/obtenertodos/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List obtenerTodos(@PathParam("usuario") String usuario, @PathParam("clave") String clave) {
		// TODO Auto-generated method stub
		return null;
	}
}
