
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.PerfilespantallasEntity;
import org.salondeventas.server.modelo.jpa.PerfilespantallasEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.PerfilespantallasPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Perfilespantallas" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("perfilespantallasPersistenceJPA")
public class PerfilespantallasPersistenceJPA extends GenericJpaService<PerfilespantallasEntity, PerfilespantallasEntityKey> implements PerfilespantallasPersistence {

	/**
	 * Constructor
	 */
	public PerfilespantallasPersistenceJPA() {
		super(PerfilespantallasEntity.class);
	}

	@Override
	public PerfilespantallasEntity load( Integer idperfiles, Integer idpantallas ) {
		// Build the composite key
		PerfilespantallasEntityKey key = new PerfilespantallasEntityKey( idperfiles, idpantallas );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idperfiles, Integer idpantallas ) {
		// Build the composite key
		PerfilespantallasEntityKey key = new PerfilespantallasEntityKey( idperfiles, idpantallas );
		return super.delete( key );
	}

	@Override
	public boolean delete(PerfilespantallasEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			PerfilespantallasEntityKey key = new PerfilespantallasEntityKey( entity.getIdperfiles(), entity.getIdpantallas() );
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
				Query query = em.createNamedQuery("PerfilespantallasEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
