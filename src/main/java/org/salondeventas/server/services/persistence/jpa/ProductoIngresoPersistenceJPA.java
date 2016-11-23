
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.ProductoIngresoEntity;
import org.salondeventas.server.modelo.jpa.ProductoIngresoEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.ProductoIngresoPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "ProductoIngreso" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("productoIngresoPersistenceJPA")
public class ProductoIngresoPersistenceJPA extends GenericJpaService<ProductoIngresoEntity, ProductoIngresoEntityKey> implements ProductoIngresoPersistence {

	/**
	 * Constructor
	 */
	public ProductoIngresoPersistenceJPA() {
		super(ProductoIngresoEntity.class);
	}

	@Override
	public ProductoIngresoEntity load( Integer idproductoIngreso, Integer idproducto ) {
		// Build the composite key
		ProductoIngresoEntityKey key = new ProductoIngresoEntityKey( idproductoIngreso, idproducto );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idproductoIngreso, Integer idproducto ) {
		// Build the composite key
		ProductoIngresoEntityKey key = new ProductoIngresoEntityKey( idproductoIngreso, idproducto );
		return super.delete( key );
	}

	@Override
	public boolean delete(ProductoIngresoEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			ProductoIngresoEntityKey key = new ProductoIngresoEntityKey( entity.getIdproductoIngreso(), entity.getIdproducto() );
			return super.delete( key );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("ProductoIngresoEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
