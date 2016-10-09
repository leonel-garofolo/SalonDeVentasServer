package org.salondeventas.server.controlador;

import org.salondeventas.server.modelo.jpa.UsuarioEntity;

public interface UsuarioController extends Controller<UsuarioEntity, java.lang.Integer>{
	public UsuarioEntity load(String usuario, String clave, Integer idusuario);
}
