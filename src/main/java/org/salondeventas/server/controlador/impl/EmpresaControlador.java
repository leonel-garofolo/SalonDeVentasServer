package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.IEmpresaControlador;
import org.salondeventas.server.modelo.jpa.EmpresaEntity;
import org.salondeventas.server.servicio.IEmpresaServicio;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/empresa")
public class EmpresaControlador implements IEmpresaControlador{
	
	@Autowired
	protected IEmpresaServicio empresaServicio;	
	@Autowired
	protected IUsuarioSeguridadServicio usuarioSeguridadServicio;			
			
	@POST
	@Path("/agregar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean agregar(@PathParam("usuario") String usuario, @PathParam("clave") String clave, EmpresaEntity entity) {
		if(usuarioSeguridadServicio.comprobarUsuario(usuario, clave)){
			return empresaServicio.agregar(entity);
		}else{
			return false;
		}		
	}
	
	@POST
	@Path("/borrar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean borrar(@PathParam("usuario") String usuario, @PathParam("clave") String clave, EmpresaEntity entity) {
		System.out.println("Borrar...");
		// TODO Auto-generated method stub
		return false;
	}

	@POST
	@Path("/obtener/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmpresaEntity obtener(@PathParam("usuario") String usuario, @PathParam("clave") String clave, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/actualizar/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizar(@PathParam("usuario") String usuario, @PathParam("clave") String clave, EmpresaEntity entity) {
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
