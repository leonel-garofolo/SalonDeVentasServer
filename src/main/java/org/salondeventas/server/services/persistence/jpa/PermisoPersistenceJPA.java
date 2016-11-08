
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PermisoEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PermisoPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Permiso" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("permisoPersistenceJPA")
public class PermisoPersistenceJPA extends GenericJpaService<PermisoEntity, String> implements PermisoPersistence {

	/**
	 * Constructor
	 */
	public PermisoPersistenceJPA() {
		super(PermisoEntity.class);
	}

	@Override
	public PermisoEntity load( String idpermiso ) {
		return super.load( idpermiso );
	}

	@Override
	public boolean delete( String idpermiso ) {
		return super.delete( idpermiso );
	}

	@Override
	public boolean delete(PermisoEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdpermiso() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("PermisoEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
