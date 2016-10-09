
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.VentaPersistence;
import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.salondeventas.server.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	private VentaPersistence ventaPersistence;

	public boolean insert(VentaEntity obj) {
		if(obj!= null){
			try {
				ventaPersistence.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean update(VentaEntity obj) {
		if(obj!= null){
			try {
				ventaPersistence.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(VentaEntity obj) {
		if(obj!= null){
			try {
				ventaPersistence.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}	

	public VentaEntity load(Integer idventa) {
		try{
			return ventaPersistence.load( idventa );
		}catch (Exception e) {
			return null;
		}		
	}
	
	public List<VentaEntity> loadAll() {		
		try {
			return ventaPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
