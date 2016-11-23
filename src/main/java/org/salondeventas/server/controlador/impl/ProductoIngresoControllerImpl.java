
package org.salondeventas.server.controlador.impl;

import java.util.List;
import org.salondeventas.server.controlador.ProductoIngresoController;
import org.salondeventas.server.modelo.jpa.ProductoIngresoEntity;
import org.salondeventas.server.services.ProductoIngresoService;
import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.util.MensajesSistema;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/productoingreso")
public class ProductoIngresoControllerImpl implements ProductoIngresoController{
	
	@Autowired
	protected ProductoIngresoService productoIngresoService;	
	@Autowired
	protected UsuarioSeguridadService usuarioSeguridadService;			
			
	@POST
	@Path("/insert/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoIngresoEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  productoIngresoService.insert(entity);
			if(estado){
				return String.valueOf(
					entity.getIdproductoIngreso() + "," +	
					entity.getIdproducto()	
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
	public String update(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoIngresoEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado= productoIngresoService.update(entity);
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
	public String delete(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoIngresoEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			boolean estado=  productoIngresoService.delete(entity);
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
	public ProductoIngresoEntity load(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave, ProductoIngresoEntity entity) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			ProductoIngresoEntity producto= productoIngresoService.load(
				entity.getIdproductoIngreso(),	
				entity.getIdproducto()	
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
	public List<ProductoIngresoEntity> loadAll(@QueryParam("usuario") String usuario, @QueryParam("clave") String clave) {
		if(usuarioSeguridadService.comprobarUsuario(usuario, clave)){
			List<ProductoIngresoEntity> productoIngresos=  productoIngresoService.loadAll();
			if(productoIngresos != null){
				return productoIngresos;
			}
			return null;
		}else{
			return null;
		}
	}
}
