package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PantallapermisosEntity;

public interface PantallapermisosService extends Service<PantallapermisosEntity, java.lang.Long>{

	public PantallapermisosEntity load(Integer idpantalla, String idpermiso);
}
