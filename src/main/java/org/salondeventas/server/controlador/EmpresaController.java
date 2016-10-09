package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.EmpresaEntity;

public interface EmpresaController extends Controller<EmpresaEntity, java.lang.Integer>{
	public EmpresaEntity load(String usuario, String clave, Integer idempresa);
}
