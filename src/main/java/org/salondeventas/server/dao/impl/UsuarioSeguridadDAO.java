package org.salondeventas.server.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.IUsuarioSeguridadDAO;
import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.springframework.stereotype.Service;

@Service("usuarioSeguridadDAO")
public class UsuarioSeguridadDAO extends GenericDAOWithHibernate<UsuarioEntity, Long> implements IUsuarioSeguridadDAO {	
	
	public boolean comprobarUsuario(String usuario, String clave) throws HibernateException{
		System.out.println("entro");
		List<UsuarioEntity> list = sessionFactory.getCurrentSession().createQuery("Select t from " + persistentClass.getSimpleName() + " t where t.nombre = '" + usuario + "' and t.clave = '" + clave + "'").list();
		if(list.size() > 0){
			return true;
		}
		return false;
	}
}
