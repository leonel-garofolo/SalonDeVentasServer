package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.ConfiguracionEntity;

public interface ConfiguracionService extends Service<ConfiguracionEntity, java.lang.Long>{

	public ConfiguracionEntity load(Integer idconfiguracion);
}
