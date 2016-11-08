
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.UsuarioperfilesEntity;
import org.salondeventas.server.modelo.jpa.UsuarioperfilesEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.UsuarioperfilesPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Usuarioperfiles" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("usuarioperfilesPersistenceJPA")
public class UsuarioperfilesPersistenceJPA extends GenericJpaService<UsuarioperfilesEntity, UsuarioperfilesEntityKey> implements UsuarioperfilesPersistence {

	/**
	 * Constructor
	 */
	public UsuarioperfilesPersistenceJPA() {
		super(UsuarioperfilesEntity.class);
	}

	@Override
	public UsuarioperfilesEntity load( Integer idusuario, Integer idperfil ) {
		// Build the composite key
		UsuarioperfilesEntityKey key = new UsuarioperfilesEntityKey( idusuario, idperfil );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idusuario, Integer idperfil ) {
		// Build the composite key
		UsuarioperfilesEntityKey key = new UsuarioperfilesEntityKey( idusuario, idperfil );
		return super.delete( key );
	}

	@Override
	public boolean delete(UsuarioperfilesEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			UsuarioperfilesEntityKey key = new UsuarioperfilesEntityKey( entity.getIdusuario(), entity.getIdperfil() );
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
				Query query = em.createNamedQuery("UsuarioperfilesEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
