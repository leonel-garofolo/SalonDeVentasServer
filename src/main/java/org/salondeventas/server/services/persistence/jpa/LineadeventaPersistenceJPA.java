
package org.salondeventas.server.services.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.modelo.jpa.LineadeventaEntityKey;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.salondeventas.server.services.persistence.LineadeventaPersistence;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Lineadeventa" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("lineadeventaPersistenceJPA")
public class LineadeventaPersistenceJPA extends GenericJpaService<LineadeventaEntity, LineadeventaEntityKey> implements LineadeventaPersistence {

	/**
	 * Constructor
	 */
	public LineadeventaPersistenceJPA() {
		super(LineadeventaEntity.class);
	}

	@Override
	public LineadeventaEntity load( Integer idlineadeventa, Integer idproducto, Integer idventa ) {
		// Build the composite key
		LineadeventaEntityKey key = new LineadeventaEntityKey( idlineadeventa, idproducto, idventa );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer idlineadeventa, Integer idproducto, Integer idventa ) {
		// Build the composite key
		LineadeventaEntityKey key = new LineadeventaEntityKey( idlineadeventa, idproducto, idventa );
		return super.delete( key );
	}

	@Override
	public boolean delete(LineadeventaEntity entity) {
		if ( entity != null ) {
			// Build the composite key
			LineadeventaEntityKey key = new LineadeventaEntityKey( entity.getIdlineadeventa(), entity.getIdproducto(), entity.getIdventa() );
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
				Query query = em.createNamedQuery("LineadeventaEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
