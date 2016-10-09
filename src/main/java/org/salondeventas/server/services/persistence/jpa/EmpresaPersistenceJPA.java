
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.EmpresaEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.EmpresaPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Empresa" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("empresaPersistenceJPA")
public class EmpresaPersistenceJPA extends GenericJpaService<EmpresaEntity, Integer> implements EmpresaPersistence {

	/**
	 * Constructor
	 */
	public EmpresaPersistenceJPA() {
		super(EmpresaEntity.class);
	}

	@Override
	public EmpresaEntity load( Integer idempresa ) {
		return super.load( idempresa );
	}

	@Override
	public boolean delete( Integer idempresa ) {
		return super.delete( idempresa );
	}

	@Override
	public boolean delete(EmpresaEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdempresa() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("EmpresaEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
