
package org.salondeventas.server.services.persistence.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.salondeventas.server.modelo.informe.jpa.VCantProdVendidosEntity;
import org.salondeventas.server.services.persistence.VCantProdVendidosPersistence;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.salondeventas.server.services.persistence.commons.jpa.JpaOperation;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "VCantProdVendidos" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("vCantProdVendidosPersistenceJPA")
public class VCantProdVendidosPersistenceJPA extends GenericJpaService<VCantProdVendidosEntity, Long> implements VCantProdVendidosPersistence {

	/**
	 * Constructor
	 */
	public VCantProdVendidosPersistenceJPA() {
		super(VCantProdVendidosEntity.class);
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("VCantProdVendidosEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}		
	/*
	@SuppressWarnings("unchecked")
	public List<VCantProdVendidosEntity> loadAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {			
				final Query query = em.createNamedQuery("from v_cant_prod_vendidos");
				return query.getResultList();
			}
		} ;
		// JPA operation execution 
		return (List<VCantProdVendidosEntity>) execute(operation) ;
	}
*/
}
