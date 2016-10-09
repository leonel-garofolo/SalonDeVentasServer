package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.LineadeventaEntity;

public interface LineadeventaController extends Controller<LineadeventaEntity, java.lang.Integer>{
	public LineadeventaEntity load(String usuario, String clave, Integer idlineadeventa, Integer idproducto, Integer idventa);
}
