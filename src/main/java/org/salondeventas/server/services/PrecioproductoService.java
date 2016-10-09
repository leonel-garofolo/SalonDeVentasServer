package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.salondeventas.server.modelo.jpa.PrecioproductoEntityKey;

public interface PrecioproductoService extends Service<PrecioproductoEntity, java.lang.Long>{

	public PrecioproductoEntity load(Integer idprecioproducto, Integer idproducto);

	public PrecioproductoEntity load(PrecioproductoEntityKey key);
}
