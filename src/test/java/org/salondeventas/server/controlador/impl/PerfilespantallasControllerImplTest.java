
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
import org.salondeventas.server.modelo.jpa.PerfilespantallasEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class PerfilespantallasControllerImplTest extends JerseyTest {
	
	private PerfilespantallasControllerImpl perfilespantallasControlador;
			
	@Override
	protected Application configure() {
		perfilespantallasControlador = Mockito.mock(PerfilespantallasControllerImpl.class);
		ResourceConfig app = new ResourceConfig(PerfilespantallasControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudPerfilespantallas() {
		String pathToCall = "perfilespantallas/insert/";

		//INSERT
		final PerfilespantallasEntity perfilespantallas = new PerfilespantallasEntity();
		perfilespantallas.setIdperfiles(100); // "idPerfiles" : java.lang.Integer
		perfilespantallas.setIdpantallas(100); // "idPantallas" : java.lang.Integer
		//--- Other values
		
		final Entity<PerfilespantallasEntity> perfilespantallasEntity = Entity.entity(perfilespantallas, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespantallasEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "perfilespantallas/load/";
		final PerfilespantallasEntity perfilespantallas2 = new PerfilespantallasEntity();
		perfilespantallas2.setIdperfiles(perfilespantallas.getIdperfiles());	
		perfilespantallas2.setIdpantallas(perfilespantallas.getIdpantallas());	
		final Entity<PerfilespantallasEntity> perfilespantallasEntity2 = Entity.entity(perfilespantallas2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespantallasEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		PerfilespantallasEntity perfilespantallas3 = responseWrapperLoad.readEntity(PerfilespantallasEntity.class);		

		//--- UPDATE
		pathToCall = "perfilespantallas/update/";		
    	//--- NO UPDATE FOR THIS ENTITY (ALL COLUMNS IN PRIMARY KEY)
				
		final Entity<PerfilespantallasEntity> perfilespantallasEntity3 = Entity.entity(perfilespantallas3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespantallasEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "perfilespantallas/delete/";						
		final Entity<PerfilespantallasEntity> perfilespantallasEntity4 = Entity.entity(perfilespantallas3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespantallasEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "perfilespantallas/loadall/";		
		final Entity<PerfilespantallasEntity> perfilespantallasEntity5 = Entity.entity(new PerfilespantallasEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(perfilespantallasEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}