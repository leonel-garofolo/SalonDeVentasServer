
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
	public void crudVenta() {
		String pathToCall = "venta/insert/";

		//INSERT
		final VentaEntity venta = new VentaEntity();
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		venta.setFecha(java.sql.Date.valueOf("2001-06-22")); // "fecha" : java.util.Date
		venta.setFechaPago(java.sql.Date.valueOf("2001-06-22")); // "fecha_pago" : java.util.Date
		venta.setTotal((new BigDecimal(10000))); // "total" : java.math.BigDecimal
		
		final Entity<VentaEntity> ventaEntity = Entity.entity(venta, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "venta/load/";
		final VentaEntity venta2 = new VentaEntity();
		venta2.setIdventa(venta.getIdventa());	
		final Entity<VentaEntity> ventaEntity2 = Entity.entity(venta2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		VentaEntity venta3 = responseWrapperLoad.readEntity(VentaEntity.class);		

		//--- UPDATE
		pathToCall = "venta/update/";		
		//--- Change values
		venta3.setFecha(java.sql.Date.valueOf("2002-06-22")); // "fecha" : java.util.Date
		venta3.setFechaPago(java.sql.Date.valueOf("2002-06-22")); // "fecha_pago" : java.util.Date
		venta3.setTotal((new BigDecimal(20000))); // "total" : java.math.BigDecimal
				
		final Entity<VentaEntity> ventaEntity3 = Entity.entity(venta3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "venta/delete/";						
		final Entity<VentaEntity> ventaEntity4 = Entity.entity(venta3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "venta/loadall/";		
		final Entity<VentaEntity> ventaEntity5 = Entity.entity(new VentaEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(ventaEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}