package org.salondeventas.server.services.impl;

import org.salondeventas.server.services.UsuarioSeguridadService;
import org.salondeventas.server.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioSeguridadServicio")
public class UsuarioSeguridadServicio implements UsuarioSeguridadService  {
	
	@Autowired
	private UsuarioService usuarioSeguridadDAO;

	public boolean comprobarUsuario(String usuario, String clave) {
		return usuarioSeguridadDAO.comprobarUsuario(usuario, clave);
	}
}
