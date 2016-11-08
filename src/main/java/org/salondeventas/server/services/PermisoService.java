package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PermisoEntity;

public interface PermisoService extends Service<PermisoEntity, java.lang.Long>{

	public PermisoEntity load(String idpermiso);
}
