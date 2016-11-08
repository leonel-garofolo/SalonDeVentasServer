
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
import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class LineadeventaControllerImplTest extends JerseyTest {
	
	private LineadeventaControllerImpl lineadeventaControlador;
			
	@Override
	protected Application configure() {
		lineadeventaControlador = Mockito.mock(LineadeventaControllerImpl.class);
		ResourceConfig app = new ResourceConfig(LineadeventaControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudLineadeventa() {
		String pathToCall = "lineadeventa/insert/";

		//INSERT
		final LineadeventaEntity lineadeventa = new LineadeventaEntity();
		lineadeventa.setIdlineadeventa(100); // "idlineadeventa" : java.lang.Integer
		lineadeventa.setIdproducto(100); // "idproducto" : java.lang.Integer
		lineadeventa.setIdventa(100); // "idVenta" : java.lang.Integer
		//--- Other values
		lineadeventa.setPrecio((new BigDecimal(10000))); // "precio" : java.math.BigDecimal
		
		final Entity<LineadeventaEntity> lineadeventaEntity = Entity.entity(lineadeventa, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(lineadeventaEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "lineadeventa/load/";
		final LineadeventaEntity lineadeventa2 = new LineadeventaEntity();
		lineadeventa2.setIdlineadeventa(lineadeventa.getIdlineadeventa());	
		lineadeventa2.setIdproducto(lineadeventa.getIdproducto());	
		lineadeventa2.setIdventa(lineadeventa.getIdventa());	
		final Entity<LineadeventaEntity> lineadeventaEntity2 = Entity.entity(lineadeventa2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(lineadeventaEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		LineadeventaEntity lineadeventa3 = responseWrapperLoad.readEntity(LineadeventaEntity.class);		

		//--- UPDATE
		pathToCall = "lineadeventa/update/";		
		//--- Change values
		lineadeventa3.setPrecio((new BigDecimal(20000))); // "precio" : java.math.BigDecimal
				
		final Entity<LineadeventaEntity> lineadeventaEntity3 = Entity.entity(lineadeventa3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(lineadeventaEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "lineadeventa/delete/";						
		final Entity<LineadeventaEntity> lineadeventaEntity4 = Entity.entity(lineadeventa3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(lineadeventaEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "lineadeventa/loadall/";		
		final Entity<LineadeventaEntity> lineadeventaEntity5 = Entity.entity(new LineadeventaEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(lineadeventaEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}