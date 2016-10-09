package org.salondeventas.server.controlador.impl;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.salondeventas.server.controlador.EmpresaController;
import org.salondeventas.server.modelo.jpa.EmpresaEntity;

@RunWith(MockitoJUnitRunner.class)
public class EmpresaControladorTest extends JerseyTest{
	
	/**
	 * Used to specify the format expected for the return type of the add call.
	 */
	private final GenericType<Boolean> BOOLEAN_RETURN_TYPE = new GenericType<Boolean>() {
	};

	/**
	 * The handler used in the {@link SetResource}. We are going to use {@link Mockito} to mock this handler for some
	 * tests, to just check the API call itself.
	 */
	private EmpresaController empresaController;

	@Override
	protected Application configure() {
		empresaController = Mockito.mock(EmpresaController.class);
		return new ResourceConfig(EmpresaController.class);
	}

	@Override
	@After
	public void tearDown() throws Exception {
		/*
		 * The super-class tearDown method takes down the server, so it has to be called.
		 */
		super.tearDown();

		/*
		 * Reset the mocking on this object so that the field can be safely re-used between tests.
		 */
		Mockito.reset(empresaController);
	}

	@Test
	public void mockedAddEmpresaAgregar() {
		final String pathToCall = "empresa/agregar/";
		
		final EmpresaEntity empresa = new EmpresaEntity();	
		empresa.setNombre("Venta de Ropa");
		
		final Entity<EmpresaEntity> empresaEntity = Entity.entity(empresa, MediaType.APPLICATION_JSON_TYPE);								
		final Response responseWrapper = target(pathToCall)
				.request(MediaType.APPLICATION_JSON_TYPE)				
				.post(empresaEntity);
		assertEquals(Response.Status.OK.getStatusCode(), responseWrapper.getStatus());
	}
}
