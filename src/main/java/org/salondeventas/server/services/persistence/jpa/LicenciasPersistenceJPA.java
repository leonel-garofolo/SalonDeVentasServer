
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.LicenciasEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.LicenciasPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Licencias" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("licenciasPersistenceJPA")
public class LicenciasPersistenceJPA extends GenericJpaService<LicenciasEntity, Integer> implements LicenciasPersistence {

	/**
	 * Constructor
	 */
	public LicenciasPersistenceJPA() {
		super(LicenciasEntity.class);
	}

	@Override
	public LicenciasEntity load( Integer numero ) {
		return super.load( numero );
	}

	@Override
	public boolean delete( Integer numero ) {
		return super.delete( numero );
	}

	@Override
	public boolean delete(LicenciasEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getNumero() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("LicenciasEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
