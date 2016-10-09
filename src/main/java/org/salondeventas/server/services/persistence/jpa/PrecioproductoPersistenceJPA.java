
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.salondeventas.server.modelo.jpa.PrecioproductoEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PrecioproductoPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Precioproducto" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("precioproductoPersistenceJPA")
public class PrecioproductoPersistenceJPA extends GenericJpaService<PrecioproductoEntity, PrecioproductoEntityKey> implements PrecioproductoPersistence {

	/**
	 * Constructor
	 */
	public PrecioproductoPersistenceJPA() {
		super(PrecioproductoEntity.class);
	}

	@Override
	public PrecioproductoEntity load( Integer idprecioproducto, Integer idproducto ) {
		// Build the composite key
		PrecioproductoEntityKey key = new PrecioproductoEntityKey( idprecioproducto, idproducto );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idprecioproducto, Integer idproducto ) {
		// Build the composite key
		PrecioproductoEntityKey key = new PrecioproductoEntityKey( idprecioproducto, idproducto );
		return super.delete( key );
	}

	@Override
	public boolean delete(PrecioproductoEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			PrecioproductoEntityKey key = new PrecioproductoEntityKey( entity.getIdprecioproducto(), entity.getIdproducto() );
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
				Query query = em.createNamedQuery("PrecioproductoEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
