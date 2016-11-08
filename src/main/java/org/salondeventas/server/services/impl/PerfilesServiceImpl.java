
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.PerfilesPersistence;
import org.salondeventas.server.modelo.jpa.PerfilesEntity;
import org.salondeventas.server.services.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("perfilesService")
public class PerfilesServiceImpl implements PerfilesService {
	
	@Autowired
	private PerfilesPersistence perfilesPersistence;

	public boolean insert(PerfilesEntity obj) {
		if(obj!= null){
			try {
				perfilesPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(PerfilesEntity obj) {
		if(obj!= null){
			try {
				perfilesPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PerfilesEntity obj) {
		if(obj!= null){
			try {
				perfilesPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public PerfilesEntity load(Integer idperfiles) {
		try{
			return perfilesPersistence.load( idperfiles );
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<PerfilesEntity> loadAll() {		
		try {
			return perfilesPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
