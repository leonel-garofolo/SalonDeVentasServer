package org.salondeventas.server.servicio.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.dao.IUsuarioDAO;
import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.salondeventas.server.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioServicio")
public class UsuarioServicio implements IUsuarioServicio {
	
	@Autowired
	private IUsuarioDAO usuarioDao;

	public boolean agregar(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public UsuarioEntity obtener(long id) {
		if(id != 0){
			try{
				return usuarioDao.get(id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioDao.update(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<UsuarioEntity> obtenerTodos() {		
		try {
			return usuarioDao.getAll();
		} catch (Exception e) {
		}
		return null;
	}
}
