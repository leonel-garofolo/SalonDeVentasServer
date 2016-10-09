/*
 * Created on 9 oct 2016 ( Time 02:32:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.salondeventas.server.test.persistence;


import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.salondeventas.server.mock.VentaEntityMock;
import org.salondeventas.server.services.persistence.commons.jpa.PersistenceServiceProvider;
import org.salondeventas.server.services.persistence.VentaPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Venta persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class VentaPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		VentaPersistence service = PersistenceServiceProvider.getService(VentaPersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test Venta persistence : delete + load ..." );
		
		VentaPersistence service = PersistenceServiceProvider.getService(VentaPersistence.class);
		
		VentaEntityMock mock = new VentaEntityMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0  );
		// process( service, mock, ... );
	}

	private void process(VentaPersistence service, VentaEntityMock mock, Integer idventa ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		VentaEntity entity = service.load( idventa );
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
			entity = mock.createInstance( idventa ) ;
			Assert.assertNotNull(entity);

			// No reference : insert is possible 
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );

			System.out.println(" . delete : " );
			boolean deleted = service.delete( idventa );
			System.out.println("   deleted = " + deleted);
			Assert.assertTrue(deleted) ;
		}		
	}
}
