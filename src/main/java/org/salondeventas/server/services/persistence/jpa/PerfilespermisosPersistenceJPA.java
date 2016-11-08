
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PerfilespermisosEntity;
import org.salondeventas.server.modelo.jpa.PerfilespermisosEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PerfilespermisosPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Perfilespermisos" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("perfilespermisosPersistenceJPA")
public class PerfilespermisosPersistenceJPA extends GenericJpaService<PerfilespermisosEntity, PerfilespermisosEntityKey> implements PerfilespermisosPersistence {

	/**
	 * Constructor
	 */
	public PerfilespermisosPersistenceJPA() {
		super(PerfilespermisosEntity.class);
	}

	@Override
	public PerfilespermisosEntity load( Integer idperfiles, String idpermisos ) {
		// Build the composite key
		PerfilespermisosEntityKey key = new PerfilespermisosEntityKey( idperfiles, idpermisos );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idperfiles, String idpermisos ) {
		// Build the composite key
		PerfilespermisosEntityKey key = new PerfilespermisosEntityKey( idperfiles, idpermisos );
		return super.delete( key );
	}

	@Override
	public boolean delete(PerfilespermisosEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			PerfilespermisosEntityKey key = new PerfilespermisosEntityKey( entity.getIdperfiles(), entity.getIdpermisos() );
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
				Query query = em.createNamedQuery("PerfilespermisosEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
