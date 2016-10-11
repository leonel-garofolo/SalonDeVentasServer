
package org.salondeventas.server.services.persistence.jpa;


import org.salondeventas.server.modelo.jpa.VproductosEntity;
import org.salondeventas.server.services.persistence.VProductoPersistence;
import org.salondeventas.server.services.persistence.commons.jpa.GenericJpaService;
import org.springframework.stereotype.Service;

/**
 * JPA implementation for basic persistence operations ( entity "Producto" )
 * 
 * @author Telosys Tools Generator
 *
 */

@Service("vproductoPersistenceJPA")
public class VproductosPersistenceJPA extends GenericJpaService<VproductosEntity, Integer> implements VProductoPersistence {

	/**
	 * Constructor
	 */
	public VproductosPersistenceJPA() {
		super(VproductosEntity.class);
	}
}
