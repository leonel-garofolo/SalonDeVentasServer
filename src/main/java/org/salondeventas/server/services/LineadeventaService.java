package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.modelo.jpa.LineadeventaEntityKey;

public interface LineadeventaService extends Service<LineadeventaEntity, java.lang.Long>{

	public LineadeventaEntity load(Integer idlineadeventa, Integer idproducto, Integer idventa);

	public LineadeventaEntity load(LineadeventaEntityKey key);
}
