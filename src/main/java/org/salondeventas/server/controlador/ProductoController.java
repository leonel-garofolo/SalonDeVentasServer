package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.ProductoEntity;

public interface ProductoController extends Controller<ProductoEntity, java.lang.Integer>{
	public ProductoEntity load(String usuario, String clave, Integer idproducto);
}
