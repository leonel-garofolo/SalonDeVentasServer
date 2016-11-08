
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PantallapermisosEntity;
import org.salondeventas.server.modelo.jpa.PantallapermisosEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PantallapermisosPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Pantallapermisos" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("pantallapermisosPersistenceJPA")
public class PantallapermisosPersistenceJPA extends GenericJpaService<PantallapermisosEntity, PantallapermisosEntityKey> implements PantallapermisosPersistence {

	/**
	 * Constructor
	 */
	public PantallapermisosPersistenceJPA() {
		super(PantallapermisosEntity.class);
	}

	@Override
	public PantallapermisosEntity load( Integer idpantalla, String idpermiso ) {
		// Build the composite key
		PantallapermisosEntityKey key = new PantallapermisosEntityKey( idpantalla, idpermiso );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idpantalla, String idpermiso ) {
		// Build the composite key
		PantallapermisosEntityKey key = new PantallapermisosEntityKey( idpantalla, idpermiso );
		return super.delete( key );
	}

	@Override
	public boolean delete(PantallapermisosEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			PantallapermisosEntityKey key = new PantallapermisosEntityKey( entity.getIdpantalla(), entity.getIdpermiso() );
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
				Query query = em.createNamedQuery("PantallapermisosEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
