package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.ProductoIngresoEntity;

public interface ProductoIngresoService extends Service<ProductoIngresoEntity, java.lang.Long>{

	public ProductoIngresoEntity load(Integer idproductoIngreso, Integer idproducto);
}
