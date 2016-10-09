package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.EmpresaEntity;

public interface EmpresaService extends Service<EmpresaEntity, java.lang.Long>{

	public EmpresaEntity load(Integer idempresa);
}
