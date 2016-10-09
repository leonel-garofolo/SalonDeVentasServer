package org.salondeventas.server.controlador.impl;

import static org.junit.Assert.assertEquals;

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
import org.salondeventas.server.controlador.PrecioproductoController;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class PrecioProductoControladorTest extends JerseyTest {
	
	private PrecioproductoController precioproductoControlador;
			
	@Override
	protected Application configure() {
		precioproductoControlador = Mockito.mock(PrecioproductoController.class);
		ResourceConfig app = new ResourceConfig();
		app.register(PrecioproductoController.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void addProducto() {
		String pathToCall = "precio/agregar/";
		
		//final Entity<PrecioproductoEntity> precioEntity = Entity.entity(precio, MediaType.APPLICATION_JSON_TYPE);						
		final Entity<String> precioEntity = Entity.entity("mensaje", MediaType.APPLICATION_JSON_TYPE);
		final Response responseWrapperPrecio = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(precioEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperPrecio.getStatus());		
	}		
}