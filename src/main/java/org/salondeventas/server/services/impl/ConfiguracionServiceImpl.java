
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.ConfiguracionPersistence;
import org.salondeventas.server.modelo.jpa.ConfiguracionEntity;
import org.salondeventas.server.services.ConfiguracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("configuracionService")
public class ConfiguracionServiceImpl implements ConfiguracionService {
	
	@Autowired
	private ConfiguracionPersistence configuracionPersistence;

	public boolean insert(ConfiguracionEntity obj) {
		if(obj!= null){
			try {
				configuracionPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(ConfiguracionEntity obj) {
		if(obj!= null){
			try {
				configuracionPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(ConfiguracionEntity obj) {
		if(obj!= null){
			try {
				configuracionPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public ConfiguracionEntity load(Integer idconfiguracion) {
		try{
			return configuracionPersistence.load( idconfiguracion );
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<ConfiguracionEntity> loadAll() {		
		try {
			return configuracionPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
