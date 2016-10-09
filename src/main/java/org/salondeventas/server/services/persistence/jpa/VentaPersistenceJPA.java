
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.VentaPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Venta" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("ventaPersistenceJPA")
public class VentaPersistenceJPA extends GenericJpaService<VentaEntity, Integer> implements VentaPersistence {

	/**
	 * Constructor
	 */
	public VentaPersistenceJPA() {
		super(VentaEntity.class);
	}

	@Override
	public VentaEntity load( Integer idventa ) {
		return super.load( idventa );
	}

	@Override
	public boolean delete( Integer idventa ) {
		return super.delete( idventa );
	}

	@Override
	public boolean delete(VentaEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdventa() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("VentaEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
