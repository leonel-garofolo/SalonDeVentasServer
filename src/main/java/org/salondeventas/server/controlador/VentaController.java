package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.VentaEntity;

public interface VentaController extends Controller<VentaEntity, java.lang.Integer>{
	public VentaEntity load(String usuario, String clave, Integer idventa);
}
