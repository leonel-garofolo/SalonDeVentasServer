package org.salondeventas.server.servicio.impl;

import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioSeguridadServicio")
public class UsuarioSeguridadServicio implements IUsuarioSeguridadServicio  {
	
	@Autowired
	private UsuarioServicio usuarioSeguridadDAO;

	public boolean comprobarUsuario(String usuario, String clave) {
		return usuarioSeguridadDAO.comprobarUsuario(usuario, clave);
	}
}
