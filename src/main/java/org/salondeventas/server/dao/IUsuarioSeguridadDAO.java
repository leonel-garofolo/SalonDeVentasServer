package org.salondeventas.server.dao;

import org.springframework.transaction.annotation.Transactional;

public interface IUsuarioSeguridadDAO {
	
	@Transactional
	boolean comprobarUsuario(String usuario, String clave);
}