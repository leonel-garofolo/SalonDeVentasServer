
package org.salondeventas.server.controlador.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.salondeventas.server.modelo.jpa.ProductoIngresoEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class ProductoIngresoControllerImplTest extends JerseyTest {
	
	private ProductoIngresoControllerImpl productoIngresoControlador;
			
	@Override
	protected Application configure() {
		productoIngresoControlador = Mockito.mock(ProductoIngresoControllerImpl.class);
		ResourceConfig app = new ResourceConfig(ProductoIngresoControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudProductoIngreso() {
		String pathToCall = "productoingreso/insert/";

		//INSERT
		final ProductoIngresoEntity productoIngreso = new ProductoIngresoEntity();
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		productoIngreso.setIdproducto(1);
		productoIngreso.setFechaingreso(java.sql.Date.valueOf("2001-06-22")); // "fechaIngreso" : java.util.Date
		productoIngreso.setCantidad(100); // "cantidad" : java.lang.Integer
		
		final Entity<ProductoIngresoEntity> productoIngresoEntity = Entity.entity(productoIngreso, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoIngresoEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "productoingreso/load/";
		final ProductoIngresoEntity productoIngreso2 = new ProductoIngresoEntity();
		productoIngreso2.setIdproducto(productoIngreso.getIdproducto());	
		final Entity<ProductoIngresoEntity> productoIngresoEntity2 = Entity.entity(productoIngreso2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoIngresoEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		ProductoIngresoEntity productoIngreso3 = responseWrapperLoad.readEntity(ProductoIngresoEntity.class);		

		//--- UPDATE
		pathToCall = "productoingreso/update/";		
		//--- Change values
		productoIngreso3.setFechaingreso(java.sql.Date.valueOf("2002-06-22")); // "fechaIngreso" : java.util.Date
		productoIngreso3.setCantidad(200); // "cantidad" : java.lang.Integer
				
		final Entity<ProductoIngresoEntity> productoIngresoEntity3 = Entity.entity(productoIngreso3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoIngresoEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "productoingreso/delete/";						
		final Entity<ProductoIngresoEntity> productoIngresoEntity4 = Entity.entity(productoIngreso3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoIngresoEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "productoingreso/loadall/";		
		final Entity<ProductoIngresoEntity> productoIngresoEntity5 = Entity.entity(new ProductoIngresoEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoIngresoEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}