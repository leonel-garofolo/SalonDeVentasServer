package org.salondeventas.server.controlador.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.ConstraintViolationException;
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
			
	@Override
	protected Application configure() {
		productoControlador = Mockito.mock(ProductoControlador.class);
		return new ResourceConfig(ProductoControlador.class);
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void mockedAddProveedor() {
		final String pathToCall = "producto/agregar/";

		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setNombre("Producto 1");
		prod1.setDetalle("producto de prueba");
		final PrecioproductoEntity precio = new PrecioproductoEntity();
		precio.setFecha(new Date());
		precio.setImporte(new BigDecimal("13.5"));
		prod1.setPrecioproducto(precio);
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
	}	
	
	@Test
	public void addProductoErrorNombre() {
		final String pathToCall = "producto/agregar/";

		final ProductoEntity prod1 = new ProductoEntity();
		prod1.setDetalle("producto de prueba");
		final PrecioproductoEntity precio = new PrecioproductoEntity();
		precio.setFecha(new Date());
		precio.setImporte(new BigDecimal("13.5"));
		prod1.setPrecioproducto(precio);
		final Entity<ProductoEntity> prodEntity = Entity.entity(prod1, MediaType.APPLICATION_JSON_TYPE);
		try{
			final Response responseWrapper = target(pathToCall)				
					.queryParam("usuario", "leonel")
					.queryParam("clave", "123")
					.request(MediaType.APPLICATION_JSON_TYPE).post(prodEntity);					
		}catch (ConstraintViolationException e) {
			e.printStackTrace();
			System.out.println("Error");
			
		}				
	}	
}