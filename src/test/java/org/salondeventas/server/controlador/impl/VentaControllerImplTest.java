
package org.salondeventas.server.controlador.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class VentaControllerImplTest extends JerseyTest {
	
	private VentaControllerImpl ventaControlador;	
			
	@Override
	protected Application configure() {
		ventaControlador = Mockito.mock(VentaControllerImpl.class);
		ResourceConfig app = new ResourceConfig(VentaControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void insertVenta() {
		String pathToCall = "venta/insert/";

		final VentaEntity unVenta = new VentaEntity();
		unVenta.setFecha(new Date());
		unVenta.setFechaPago(new Date());
		ProductoEntity unProd = new ProductoEntity();
		unProd.setIdproducto(44);				
		LineadeventaEntity unaLinea = new LineadeventaEntity();
		unaLinea.setIdventa(1);
		unaLinea.setIdproducto(44);
		//unaLinea.setProducto(producto);		
		List<LineadeventaEntity> listOfLineadeventa = new ArrayList<LineadeventaEntity>();
		listOfLineadeventa.add(unaLinea);
		unVenta.setListOfLineadeventa(listOfLineadeventa );
		
		
		final Entity<VentaEntity> ventaEntity = Entity.entity(unVenta, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
		
		unVenta.setIdventa(Integer.valueOf(responseWrapper.readEntity(String.class)));		
	}
	
	@Test
	public void updateVenta() {
		String pathToCall = "venta/update/";

		final VentaEntity unVenta = new VentaEntity();
		unVenta.setIdventa(1);
		unVenta.setFecha(new Date());
		unVenta.setFechaPago(new Date());
		final Entity<VentaEntity> ventaEntity = Entity.entity(unVenta, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());		
	}	
	
	@Test
	public void loadVenta() {
		final String pathToCall = "venta/load/";

		final VentaEntity unVenta = new VentaEntity();	
		unVenta.setIdventa(5);
		final Entity<VentaEntity> ventaEntity = Entity.entity(unVenta, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
	}	
	
		
	@Test
	public void loadAll() {
		final String pathToCall = "venta/loadall/";
		final Response responseWrapper = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(null);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());			
	}		
}