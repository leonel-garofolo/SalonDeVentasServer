package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.PantallaEntity;

public interface PantallaService extends Service<PantallaEntity, java.lang.Long>{

	public PantallaEntity load(Integer idpantalla);
}
