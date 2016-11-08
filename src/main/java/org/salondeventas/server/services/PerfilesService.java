package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PerfilesEntity;

public interface PerfilesService extends Service<PerfilesEntity, java.lang.Long>{

	public PerfilesEntity load(Integer idperfiles);
}
