
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
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext.xml"})
@WebAppConfiguration
public class ProductoControllerImplTest extends JerseyTest {
	
	private ProductoControllerImpl productoControlador;
			
	@Override
	protected Application configure() {
		productoControlador = Mockito.mock(ProductoControllerImpl.class);
		ResourceConfig app = new ResourceConfig(ProductoControllerImpl.class);
		return app;
	}	

    @After
    public void after() throws Exception {
        super.tearDown();
    }
    
	@Test
	public void crudProducto() {
		String pathToCall = "producto/insert/";

		//INSERT
		final ProductoEntity producto = new ProductoEntity();
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		producto.setNombre("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "nombre" : java.lang.String
		producto.setCodbarras("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "codBarras" : java.lang.String
		producto.setMininventario(100); // "minInventario" : java.lang.Integer
		producto.setPrecio((new BigDecimal(10000))); // "precio" : java.math.BigDecimal
		producto.setCantidadStock(100); // "cantidad_stock" : java.lang.Integer
		
		final Entity<ProductoEntity> productoEntity = Entity.entity(producto, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperInsert = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoEntity);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperInsert.getStatus());
		producto.setIdproducto(Integer.valueOf(responseWrapperInsert.readEntity(String.class)));
		
    	//--- FIND
    	System.out.println("Find..." );
		pathToCall = "producto/load/";
		final ProductoEntity producto2 = new ProductoEntity();
		producto2.setIdproducto(producto.getIdproducto());	
		final Entity<ProductoEntity> productoEntity2 = Entity.entity(producto2, MediaType.APPLICATION_JSON_TYPE);				
		final Response responseWrapperLoad = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")				
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoEntity2);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoad.getStatus());		
		ProductoEntity producto3 = responseWrapperLoad.readEntity(ProductoEntity.class);		

		//--- UPDATE
		pathToCall = "producto/update/";		
		//--- Change values
		producto3.setNombre("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "nombre" : java.lang.String
		producto3.setCodbarras("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "codBarras" : java.lang.String
		producto3.setMininventario(200); // "minInventario" : java.lang.Integer
		producto3.setPrecio((new BigDecimal(20000))); // "precio" : java.math.BigDecimal
		producto3.setCantidadStock(200); // "cantidad_stock" : java.lang.Integer
				
		final Entity<ProductoEntity> productoEntity3 = Entity.entity(producto3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperUpdate = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoEntity3);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperUpdate.getStatus());

		//--- DELETE
		pathToCall = "producto/delete/";						
		final Entity<ProductoEntity> productoEntity4 = Entity.entity(producto3, MediaType.APPLICATION_JSON_TYPE);										
		final Response responseWrapperDelete = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoEntity4);				
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperDelete.getStatus());	

		//--- LOAD ALL
		pathToCall = "producto/loadall/";		
		final Entity<ProductoEntity> productoEntity5 = Entity.entity(new ProductoEntity(), MediaType.APPLICATION_JSON_TYPE);												
		final Response responseWrapperLoadAll = target(pathToCall)				
				.queryParam("usuario", "leonel")
				.queryParam("clave", "123")
				.request(MediaType.APPLICATION_JSON_TYPE).post(productoEntity5);		
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapperLoadAll.getStatus());
		System.out.println(responseWrapperLoadAll.readEntity(String.class));			
	}			
}