
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.LicenciasPersistence;
import org.salondeventas.server.modelo.jpa.LicenciasEntity;
import org.salondeventas.server.services.LicenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("licenciasService")
public class LicenciasServiceImpl implements LicenciasService {
	
	@Autowired
	private LicenciasPersistence licenciasPersistence;

	public boolean insert(LicenciasEntity obj) {
		if(obj!= null){
			try {
				licenciasPersistence.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean update(LicenciasEntity obj) {
		if(obj!= null){
			try {
				licenciasPersistence.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(LicenciasEntity obj) {
		if(obj!= null){
			try {
				licenciasPersistence.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}	

	public LicenciasEntity load(Integer numero) {
		try{
			return licenciasPersistence.load( numero );
		}catch (Exception e) {
			return null;
		}		
	}
	
	public List<LicenciasEntity> loadAll() {		
		try {
			return licenciasPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
