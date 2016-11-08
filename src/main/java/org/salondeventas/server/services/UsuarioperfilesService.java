package org.salondeventas.server.services;

import org.salondeventas.server.modelo.jpa.UsuarioperfilesEntity;

public interface UsuarioperfilesService extends Service<UsuarioperfilesEntity, java.lang.Long>{

	public UsuarioperfilesEntity load(Integer idusuario, Integer idperfil);
}
