
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.UsuarioperfilesPersistence;
import org.salondeventas.server.modelo.jpa.UsuarioperfilesEntity;
import org.salondeventas.server.services.UsuarioperfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioperfilesService")
public class UsuarioperfilesServiceImpl implements UsuarioperfilesService {
	
	@Autowired
	private UsuarioperfilesPersistence usuarioperfilesPersistence;

	public boolean insert(UsuarioperfilesEntity obj) {
		if(obj!= null){
			try {
				usuarioperfilesPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(UsuarioperfilesEntity obj) {
		if(obj!= null){
			try {
				usuarioperfilesPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(UsuarioperfilesEntity obj) {
		if(obj!= null){
			try {
				usuarioperfilesPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public UsuarioperfilesEntity load(Integer idusuario, Integer idperfil) {
		try{
			return usuarioperfilesPersistence.load( idusuario, idperfil );	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<UsuarioperfilesEntity> loadAll() {		
		try {
			return usuarioperfilesPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
