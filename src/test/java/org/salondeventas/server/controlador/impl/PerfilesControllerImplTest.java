
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
import org.salondeventas.server.modelo.jpa.PerfilesEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class PerfilesControllerImplTest extends JerseyTest {
	
	private PerfilesControllerImpl perfilesControlador;
			
	@Override
	protected Application configure() {
		perfilesControlador = Mockito.mock(PerfilesControllerImpl.class);
		ResourceConfig app = new ResourceConfig(PerfilesControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudPerfiles() {
		String pathToCall = "perfiles/insert/";

		//INSERT
		final PerfilesEntity perfiles = new PerfilesEntity();
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		perfiles.setNombre("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "nombre" : java.lang.String
		
		final Entity<PerfilesEntity> perfilesEntity = Entity.entity(perfiles, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilesEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "perfiles/load/";
		final PerfilesEntity perfiles2 = new PerfilesEntity();
		perfiles2.setIdperfiles(perfiles.getIdperfiles());	
		final Entity<PerfilesEntity> perfilesEntity2 = Entity.entity(perfiles2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilesEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		PerfilesEntity perfiles3 = responseWrapperLoad.readEntity(PerfilesEntity.class);		

		//--- UPDATE
		pathToCall = "perfiles/update/";		
		//--- Change values
		perfiles3.setNombre("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "nombre" : java.lang.String
				
		final Entity<PerfilesEntity> perfilesEntity3 = Entity.entity(perfiles3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilesEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "perfiles/delete/";						
		final Entity<PerfilesEntity> perfilesEntity4 = Entity.entity(perfiles3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilesEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "perfiles/loadall/";		
		final Entity<PerfilesEntity> perfilesEntity5 = Entity.entity(new PerfilesEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilesEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}