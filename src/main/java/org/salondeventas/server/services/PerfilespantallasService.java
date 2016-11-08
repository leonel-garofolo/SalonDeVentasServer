package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PerfilespantallasEntity;

public interface PerfilespantallasService extends Service<PerfilespantallasEntity, java.lang.Long>{

	public PerfilespantallasEntity load(Integer idperfiles, Integer idpantallas);
}
