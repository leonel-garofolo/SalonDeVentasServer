
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.UsuarioPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Usuario" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("usuarioPersistenceJPA")
public class UsuarioPersistenceJPA extends GenericJpaService<UsuarioEntity, Integer> implements UsuarioPersistence {

	/**
	 * Constructor
	 */
	public UsuarioPersistenceJPA() {
		super(UsuarioEntity.class);
	}

	@Override
	public UsuarioEntity load( Integer idusuario ) {
		return super.load( idusuario );
	}

	@Override
	public boolean delete( Integer idusuario ) {
		return super.delete( idusuario );
	}

	@Override
	public boolean delete(UsuarioEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdusuario() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("UsuarioEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
