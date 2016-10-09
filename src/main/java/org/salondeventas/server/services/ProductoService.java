package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.ProductoEntity;

public interface ProductoService extends Service<ProductoEntity, java.lang.Long>{

	public ProductoEntity load(Integer idproducto);
}
