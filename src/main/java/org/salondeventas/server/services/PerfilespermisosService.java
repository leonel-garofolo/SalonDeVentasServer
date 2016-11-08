package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PerfilespermisosEntity;

public interface PerfilespermisosService extends Service<PerfilespermisosEntity, java.lang.Long>{

	public PerfilespermisosEntity load(Integer idperfiles, String idpermisos);
}
