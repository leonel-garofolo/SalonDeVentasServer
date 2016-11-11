package org.salondeventas.server.controlador.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class ProductoControladorTest extends JerseyTest {
	
	private ProductoControllerImpl productoControlador;
			
	@Override
	protected Application configure() {
		productoControlador = Mockito.mock(ProductoControllerImpl.class);
		MyApplication app = new MyApplication();		
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void addProducto() {
		String pathToCall = "producto/insert/";

		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setNombre("Producto barras");
		prod1.setCodbarras("000015868451685");
		prod1.setPrecio(new BigDecimal(15.3));
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
		
		prod1.setIdproducto(Integer.valueOf(responseWrapper.readEntity(String.class)));
	}
	
	@Test
	public void actualizarProducto() {
		String pathToCall = "producto/update/";

		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setIdproducto(70);
		prod1.setNombre("Producto 3-4-5");
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());		
	}	

	@Test
	public void loadPoducto() {
		final String pathToCall = "producto/load/";
		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setIdproducto(93);
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);
		System.out.println(responseWrapper.readEntity(String.class));
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
	}	
	
	@Test
	public void loadAll() {
		final String pathToCall = "producto/loadall/";		
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(null);
		String content = responseWrapper.toString();        
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());					
	}	
	
}