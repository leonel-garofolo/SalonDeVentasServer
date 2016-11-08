
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.PerfilespermisosPersistence;
import org.salondeventas.server.modelo.jpa.PerfilespermisosEntity;
import org.salondeventas.server.services.PerfilespermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("perfilespermisosService")
public class PerfilespermisosServiceImpl implements PerfilespermisosService {
	
	@Autowired
	private PerfilespermisosPersistence perfilespermisosPersistence;

	public boolean insert(PerfilespermisosEntity obj) {
		if(obj!= null){
			try {
				perfilespermisosPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(PerfilespermisosEntity obj) {
		if(obj!= null){
			try {
				perfilespermisosPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PerfilespermisosEntity obj) {
		if(obj!= null){
			try {
				perfilespermisosPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public PerfilespermisosEntity load(Integer idperfiles, String idpermisos) {
		try{
			return perfilespermisosPersistence.load( idperfiles, idpermisos );	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<PerfilespermisosEntity> loadAll() {		
		try {
			return perfilespermisosPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
