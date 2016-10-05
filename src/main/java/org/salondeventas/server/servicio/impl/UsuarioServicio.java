package org.salondeventas.server.servicio.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.salondeventas.server.persistence.services.UsuarioPersistence;
import org.salondeventas.server.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioServicio")
public class UsuarioServicio implements IUsuarioServicio {
	
	@Autowired
	private UsuarioPersistence usuarioDao;

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
				return usuarioDao.load((int)id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<UsuarioEntity> obtenerTodos() {		
		try {
			return usuarioDao.loadAll();
		} catch (Exception e) {
		}
		return null;
	}


	public boolean comprobarUsuario(String usuario, String clave) {
		// TODO Auto-generated method stub
		return true;
	}
}
