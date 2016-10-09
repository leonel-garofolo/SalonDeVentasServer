
package org.salondeventas.server.services.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.UsuarioEntity;
import org.salondeventas.server.services.UsuarioService;
import org.salondeventas.server.services.persistence.UsuarioPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioPersistence usuarioPersistence;

	public boolean insert(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioPersistence.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean update(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioPersistence.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(UsuarioEntity obj) {
		if(obj!= null){
			try {
				usuarioPersistence.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}	

	public UsuarioEntity load(Integer idusuario) {
		try{
			return usuarioPersistence.load( idusuario );
		}catch (Exception e) {
			return null;
		}		
	}
	
	public List<UsuarioEntity> loadAll() {		
		try {
			return usuarioPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public boolean comprobarUsuario(String usuario, String clave) {
		// TODO Auto-generated method stub
		return true;
	}
}
