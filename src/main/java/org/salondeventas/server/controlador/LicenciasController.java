package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.LicenciasEntity;

public interface LicenciasController extends Controller<LicenciasEntity, java.lang.Integer>{
	public LicenciasEntity load(String usuario, String clave, Integer numero);
}
