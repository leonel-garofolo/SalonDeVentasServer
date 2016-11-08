
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.PermisoPersistence;
import org.salondeventas.server.modelo.jpa.PermisoEntity;
import org.salondeventas.server.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("permisoService")
public class PermisoServiceImpl implements PermisoService {
	
	@Autowired
	private PermisoPersistence permisoPersistence;

	public boolean insert(PermisoEntity obj) {
		if(obj!= null){
			try {
				permisoPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(PermisoEntity obj) {
		if(obj!= null){
			try {
				permisoPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PermisoEntity obj) {
		if(obj!= null){
			try {
				permisoPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public PermisoEntity load(String idpermiso) {
		try{
			return permisoPersistence.load( idpermiso );
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<PermisoEntity> loadAll() {		
		try {
			return permisoPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
