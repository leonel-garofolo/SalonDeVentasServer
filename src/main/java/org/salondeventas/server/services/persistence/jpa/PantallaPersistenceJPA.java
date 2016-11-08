
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PantallaEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PantallaPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Pantalla" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("pantallaPersistenceJPA")
public class PantallaPersistenceJPA extends GenericJpaService<PantallaEntity, Integer> implements PantallaPersistence {

	/**
	 * Constructor
	 */
	public PantallaPersistenceJPA() {
		super(PantallaEntity.class);
	}

	@Override
	public PantallaEntity load( Integer idpantalla ) {
		return super.load( idpantalla );
	}

	@Override
	public boolean delete( Integer idpantalla ) {
		return super.delete( idpantalla );
	}

	@Override
	public boolean delete(PantallaEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdpantalla() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("PantallaEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
