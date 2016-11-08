
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PerfilesEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PerfilesPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Perfiles" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("perfilesPersistenceJPA")
public class PerfilesPersistenceJPA extends GenericJpaService<PerfilesEntity, Integer> implements PerfilesPersistence {

	/**
	 * Constructor
	 */
	public PerfilesPersistenceJPA() {
		super(PerfilesEntity.class);
	}

	@Override
	public PerfilesEntity load( Integer idperfiles ) {
		return super.load( idperfiles );
	}

	@Override
	public boolean delete( Integer idperfiles ) {
		return super.delete( idperfiles );
	}

	@Override
	public boolean delete(PerfilesEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdperfiles() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("PerfilesEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
