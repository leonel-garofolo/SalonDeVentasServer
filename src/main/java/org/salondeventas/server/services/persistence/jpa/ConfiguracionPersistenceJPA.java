
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.ConfiguracionEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.ConfiguracionPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Configuracion" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("configuracionPersistenceJPA")
public class ConfiguracionPersistenceJPA extends GenericJpaService<ConfiguracionEntity, Integer> implements ConfiguracionPersistence {

	/**
	 * Constructor
	 */
	public ConfiguracionPersistenceJPA() {
		super(ConfiguracionEntity.class);
	}

	@Override
	public ConfiguracionEntity load( Integer idconfiguracion ) {
		return super.load( idconfiguracion );
	}

	@Override
	public boolean delete( Integer idconfiguracion ) {
		return super.delete( idconfiguracion );
	}

	@Override
	public boolean delete(ConfiguracionEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdconfiguracion() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("ConfiguracionEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
