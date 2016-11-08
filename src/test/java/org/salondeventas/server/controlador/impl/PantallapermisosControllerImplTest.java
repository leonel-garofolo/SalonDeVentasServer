
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
import org.salondeventas.server.modelo.jpa.PantallapermisosEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class PantallapermisosControllerImplTest extends JerseyTest {
	
	private PantallapermisosControllerImpl pantallapermisosControlador;
			
	@Override
	protected Application configure() {
		pantallapermisosControlador = Mockito.mock(PantallapermisosControllerImpl.class);
		ResourceConfig app = new ResourceConfig(PantallapermisosControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudPantallapermisos() {
		String pathToCall = "pantallapermisos/insert/";

		//INSERT
		final PantallapermisosEntity pantallapermisos = new PantallapermisosEntity();
		pantallapermisos.setIdpantalla(100); // "idPantalla" : java.lang.Integer
		pantallapermisos.setIdpermiso("AAAAAAAAAA"); // "idPermiso" : java.lang.String
		//--- Other values
		
		final Entity<PantallapermisosEntity> pantallapermisosEntity = Entity.entity(pantallapermisos, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(pantallapermisosEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "pantallapermisos/load/";
		final PantallapermisosEntity pantallapermisos2 = new PantallapermisosEntity();
		pantallapermisos2.setIdpantalla(pantallapermisos.getIdpantalla());	
		pantallapermisos2.setIdpermiso(pantallapermisos.getIdpermiso());	
		final Entity<PantallapermisosEntity> pantallapermisosEntity2 = Entity.entity(pantallapermisos2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(pantallapermisosEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		PantallapermisosEntity pantallapermisos3 = responseWrapperLoad.readEntity(PantallapermisosEntity.class);		

		//--- UPDATE
		pathToCall = "pantallapermisos/update/";		
    	//--- NO UPDATE FOR THIS ENTITY (ALL COLUMNS IN PRIMARY KEY)
				
		final Entity<PantallapermisosEntity> pantallapermisosEntity3 = Entity.entity(pantallapermisos3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(pantallapermisosEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "pantallapermisos/delete/";						
		final Entity<PantallapermisosEntity> pantallapermisosEntity4 = Entity.entity(pantallapermisos3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(pantallapermisosEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "pantallapermisos/loadall/";		
		final Entity<PantallapermisosEntity> pantallapermisosEntity5 = Entity.entity(new PantallapermisosEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(pantallapermisosEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}