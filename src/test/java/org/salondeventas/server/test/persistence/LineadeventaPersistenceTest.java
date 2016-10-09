/*
 * Created on 9 oct 2016 ( Time 02:32:35 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.salondeventas.server.test.persistence;


import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.mock.LineadeventaEntityMock;
import org.salondeventas.server.services.persistence.commons.jpa.PersistenceServiceProvider;
import org.salondeventas.server.services.persistence.LineadeventaPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Lineadeventa persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class LineadeventaPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		LineadeventaPersistence service = PersistenceServiceProvider.getService(LineadeventaPersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test Lineadeventa persistence : delete + load ..." );
		
		LineadeventaPersistence service = PersistenceServiceProvider.getService(LineadeventaPersistence.class);
		
		LineadeventaEntityMock mock = new LineadeventaEntityMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0 , 0 , 0  );
		// process( service, mock, ... );
	}

	private void process(LineadeventaPersistence service, LineadeventaEntityMock mock, Integer idlineadeventa, Integer idproducto, Integer idventa ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		LineadeventaEntity entity = service.load( idlineadeventa, idproducto, idventa );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( idlineadeventa, idproducto, idventa ) ;
			Assert.assertNotNull(entity);

			// This entity references the following entities : 
			// . Venta
			// . Producto
			/* Insert only if references are OK
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );
			*/

			System.out.println(" . delete : " );
			boolean deleted = service.delete( idlineadeventa, idproducto, idventa );
			System.out.println("   deleted = " + deleted);
		}		
	}
}
