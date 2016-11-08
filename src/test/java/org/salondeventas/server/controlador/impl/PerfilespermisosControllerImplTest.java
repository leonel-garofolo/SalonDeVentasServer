
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
import org.salondeventas.server.modelo.jpa.PerfilespermisosEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class PerfilespermisosControllerImplTest extends JerseyTest {
	
	private PerfilespermisosControllerImpl perfilespermisosControlador;
			
	@Override
	protected Application configure() {
		perfilespermisosControlador = Mockito.mock(PerfilespermisosControllerImpl.class);
		ResourceConfig app = new ResourceConfig(PerfilespermisosControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudPerfilespermisos() {
		String pathToCall = "perfilespermisos/insert/";

		//INSERT
		final PerfilespermisosEntity perfilespermisos = new PerfilespermisosEntity();
		perfilespermisos.setIdperfiles(100); // "idPerfiles" : java.lang.Integer
		perfilespermisos.setIdpermisos("AAAAAAAAAA"); // "idPermisos" : java.lang.String
		//--- Other values
		
		final Entity<PerfilespermisosEntity> perfilespermisosEntity = Entity.entity(perfilespermisos, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespermisosEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "perfilespermisos/load/";
		final PerfilespermisosEntity perfilespermisos2 = new PerfilespermisosEntity();
		perfilespermisos2.setIdperfiles(perfilespermisos.getIdperfiles());	
		perfilespermisos2.setIdpermisos(perfilespermisos.getIdpermisos());	
		final Entity<PerfilespermisosEntity> perfilespermisosEntity2 = Entity.entity(perfilespermisos2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespermisosEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		PerfilespermisosEntity perfilespermisos3 = responseWrapperLoad.readEntity(PerfilespermisosEntity.class);		

		//--- UPDATE
		pathToCall = "perfilespermisos/update/";		
    	//--- NO UPDATE FOR THIS ENTITY (ALL COLUMNS IN PRIMARY KEY)
				
		final Entity<PerfilespermisosEntity> perfilespermisosEntity3 = Entity.entity(perfilespermisos3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespermisosEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "perfilespermisos/delete/";						
		final Entity<PerfilespermisosEntity> perfilespermisosEntity4 = Entity.entity(perfilespermisos3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespermisosEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "perfilespermisos/loadall/";		
		final Entity<PerfilespermisosEntity> perfilespermisosEntity5 = Entity.entity(new PerfilespermisosEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespermisosEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}