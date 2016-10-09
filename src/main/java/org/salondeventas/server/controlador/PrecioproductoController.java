package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;

public interface PrecioproductoController extends Controller<PrecioproductoEntity, java.lang.Integer>{
	public PrecioproductoEntity load(String usuario, String clave, Integer idprecioproducto, Integer idproducto);
}
