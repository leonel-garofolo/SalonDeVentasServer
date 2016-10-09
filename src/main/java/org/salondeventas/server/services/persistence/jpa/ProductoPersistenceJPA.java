
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.ProductoPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Producto" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("productoPersistenceJPA")
public class ProductoPersistenceJPA extends GenericJpaService<ProductoEntity, Integer> implements ProductoPersistence {

	/**
	 * Constructor
	 */
	public ProductoPersistenceJPA() {
		super(ProductoEntity.class);
	}

	@Override
	public ProductoEntity load( Integer idproducto ) {
		return super.load( idproducto );
	}

	@Override
	public boolean delete( Integer idproducto ) {
		return super.delete( idproducto );
	}

	@Override
	public boolean delete(ProductoEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdproducto() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("ProductoEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
