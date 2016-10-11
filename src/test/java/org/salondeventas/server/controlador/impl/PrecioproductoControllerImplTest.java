
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
import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class PrecioproductoControllerImplTest extends JerseyTest {
	
	private PrecioproductoControllerImpl precioproductoControlador;
			
	@Override
	protected Application configure() {
		precioproductoControlador = Mockito.mock(PrecioproductoControllerImpl.class);
		ResourceConfig app = new ResourceConfig(PrecioproductoControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void insertPrecioproducto() {
		String pathToCall = "precioproducto/insert/";

		final PrecioproductoEntity unPrecioproducto = new PrecioproductoEntity();
		
		final Entity<PrecioproductoEntity> precioproductoEntity = Entity.entity(unPrecioproducto, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(precioproductoEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
		
		unPrecioproducto.setIdprecioproducto(Integer.valueOf(responseWrapper.readEntity(String.class)));		
	}
	
	@Test
	public void updatePrecioproducto() {
		String pathToCall = "precioproducto/update/";

		final PrecioproductoEntity unPrecioproducto = new PrecioproductoEntity();
		
		final Entity<PrecioproductoEntity> precioproductoEntity = Entity.entity(unPrecioproducto, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(precioproductoEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());		
	}	
	
	@Test
	public void loadPrecioproducto() {
		final String pathToCall = "precioproducto/load/";

		final PrecioproductoEntity unPrecioproducto = new PrecioproductoEntity();		
		final Entity<PrecioproductoEntity> precioproductoEntity = Entity.entity(unPrecioproducto, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(precioproductoEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
	}	
	
		
	@Test
	public void loadAll() {
		final String pathToCall = "producto/loadall/";
		/*
		final ProductoEntity prod1 = new ProductoEntity();		
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);
		try{
			final Response responseWrapper = target(pathToCall)				
					.queryParam("usuario", "leonel")
					.queryParam("clave", "123")
					.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);
			String content = responseWrapper.toString();
	        System.out.println("Output : " + content);
			assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
		}catch (ConstraintViolationException e) {
			e.printStackTrace();
			System.out.println("Error");
			
		}
		*/				
	}		
}