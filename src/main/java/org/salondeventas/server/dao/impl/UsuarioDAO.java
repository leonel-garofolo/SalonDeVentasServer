package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.IUsuarioDAO;
import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.springframework.stereotype.Service;

@Service("usuarioDao")
public class UsuarioDAO extends GenericDAOWithHibernate<UsuarioEntity, Long> implements IUsuarioDAO {	
		
}
