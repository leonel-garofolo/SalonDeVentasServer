package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.VentaEntity;

public interface VentaService extends Service<VentaEntity, java.lang.Long>{

	public VentaEntity load(Integer idventa);
}
