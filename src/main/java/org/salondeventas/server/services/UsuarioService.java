package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.UsuarioEntity;

public interface UsuarioService extends Service<UsuarioEntity, java.lang.Long>{

	public UsuarioEntity load(Integer idusuario);

	public boolean comprobarUsuario(String usuario, String clave);
}
