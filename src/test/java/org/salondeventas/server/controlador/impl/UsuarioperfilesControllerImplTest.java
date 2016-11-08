
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
import org.salondeventas.server.modelo.jpa.UsuarioperfilesEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class UsuarioperfilesControllerImplTest extends JerseyTest {
	
	private UsuarioperfilesControllerImpl usuarioperfilesControlador;
			
	@Override
	protected Application configure() {
		usuarioperfilesControlador = Mockito.mock(UsuarioperfilesControllerImpl.class);
		ResourceConfig app = new ResourceConfig(UsuarioperfilesControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudUsuarioperfiles() {
		String pathToCall = "usuarioperfiles/insert/";

		//INSERT
		final UsuarioperfilesEntity usuarioperfiles = new UsuarioperfilesEntity();
		usuarioperfiles.setIdusuario(100); // "idUsuario" : java.lang.Integer
		usuarioperfiles.setIdperfil(100); // "idPerfil" : java.lang.Integer
		//--- Other values
		
		final Entity<UsuarioperfilesEntity> usuarioperfilesEntity = Entity.entity(usuarioperfiles, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(usuarioperfilesEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "usuarioperfiles/load/";
		final UsuarioperfilesEntity usuarioperfiles2 = new UsuarioperfilesEntity();
		usuarioperfiles2.setIdusuario(usuarioperfiles.getIdusuario());	
		usuarioperfiles2.setIdperfil(usuarioperfiles.getIdperfil());	
		final Entity<UsuarioperfilesEntity> usuarioperfilesEntity2 = Entity.entity(usuarioperfiles2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(usuarioperfilesEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		UsuarioperfilesEntity usuarioperfiles3 = responseWrapperLoad.readEntity(UsuarioperfilesEntity.class);		

		//--- UPDATE
		pathToCall = "usuarioperfiles/update/";		
    	//--- NO UPDATE FOR THIS ENTITY (ALL COLUMNS IN PRIMARY KEY)
				
		final Entity<UsuarioperfilesEntity> usuarioperfilesEntity3 = Entity.entity(usuarioperfiles3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(usuarioperfilesEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "usuarioperfiles/delete/";						
		final Entity<UsuarioperfilesEntity> usuarioperfilesEntity4 = Entity.entity(usuarioperfiles3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(usuarioperfilesEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "usuarioperfiles/loadall/";		
		final Entity<UsuarioperfilesEntity> usuarioperfilesEntity5 = Entity.entity(new UsuarioperfilesEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(usuarioperfilesEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}