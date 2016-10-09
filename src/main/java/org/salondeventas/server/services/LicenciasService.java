package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.LicenciasEntity;

public interface LicenciasService extends Service<LicenciasEntity, java.lang.Long>{

	public LicenciasEntity load(Integer numero);
}
