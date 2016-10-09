
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.EmpresaPersistence;
import org.salondeventas.server.modelo.jpa.EmpresaEntity;
import org.salondeventas.server.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empresaService")
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	private EmpresaPersistence empresaPersistence;

	public boolean insert(EmpresaEntity obj) {
		if(obj!= null){
			try {
				empresaPersistence.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean update(EmpresaEntity obj) {
		if(obj!= null){
			try {
				empresaPersistence.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(EmpresaEntity obj) {
		if(obj!= null){
			try {
				empresaPersistence.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}	

	public EmpresaEntity load(Integer idempresa) {
		try{
			return empresaPersistence.load( idempresa );
		}catch (Exception e) {
			return null;
		}		
	}
	
	public List<EmpresaEntity> loadAll() {		
		try {
			return empresaPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
