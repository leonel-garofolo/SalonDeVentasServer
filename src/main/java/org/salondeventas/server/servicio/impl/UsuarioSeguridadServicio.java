package org.salondeventas.server.servicio.impl;

import org.salondeventas.server.dao.IUsuarioSeguridadDAO;
import org.salondeventas.server.servicio.IUsuarioSeguridadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioSeguridadServicio")
public class UsuarioSeguridadServicio implements IUsuarioSeguridadServicio  {
	
	@Autowired
	private IUsuarioSeguridadDAO usuarioSeguridadDAO;

	public boolean comprobarUsuario(String usuario, String clave) {
		System.out.println("Entro a servicio UsuarioSeguridadServicio");
		return usuarioSeguridadDAO.comprobarUsuario(usuario, clave);
	}
}
