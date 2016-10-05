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
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class ProductoControladorTest extends JerseyTest {
	
	private ProductoControlador productoControlador;
	private PrecioproductoControlador precioproductoControlador;
			
	@Override
	protected Application configure() {
		productoControlador = Mockito.mock(ProductoControlador.class);
		precioproductoControlador = Mockito.mock(PrecioproductoControlador.class);
		ResourceConfig app = new ResourceConfig(ProductoControlador.class);
		app.register(PrecioproductoControlador.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void addProducto() {
		String pathToCall = "producto/agregar/";

		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setNombre("Producto 3");
		prod1.setDetalle("producto de prueba");				
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
		
		prod1.setIdproducto(Integer.valueOf(responseWrapper.readEntity(String.class)));
		final PrecioproductoEntity precio = new PrecioproductoEntity();	
		precio.setIdproducto(prod1.getIdproducto());
		precio.setFecha(new Date());
		precio.setImporte(new BigDecimal("13.5"));
		
		pathToCall = "precioproducto/agregar/";
		final Entity<PrecioproductoEntity> precioEntity = Entity.entity(precio, MediaType.APPLICATION_JSON_TYPE);						
		final Response responseWrapperPrecio = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(precioEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperPrecio.getStatus());
		
		

	}
	
	@Test
	public void actualizarProducto() {
		String pathToCall = "producto/actualizar/";

		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setIdproducto(70);
		prod1.setNombre("Producto 3-4-5");
		prod1.setDetalle("producto de prueba");				
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());		
	}	
	/*
	@Test
	public void getPoducto() {
		final String pathToCall = "producto/obtener/";

		final Entity<Long> prodEntity = Entity.entity((long)1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.queryParam("id", "1")
				.request(MediaType.APPLICATION_JSON_TYPE).get();				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
	}	
	
		
	@Test
	public void getAll() {
		final String pathToCall = "producto/obtenertodosjson/";

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
	}	
	*/
}