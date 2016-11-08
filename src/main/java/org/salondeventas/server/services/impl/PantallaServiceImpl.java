
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.PantallaPersistence;
import org.salondeventas.server.modelo.jpa.PantallaEntity;
import org.salondeventas.server.services.PantallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pantallaService")
public class PantallaServiceImpl implements PantallaService {
	
	@Autowired
	private PantallaPersistence pantallaPersistence;

	public boolean insert(PantallaEntity obj) {
		if(obj!= null){
			try {
				pantallaPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(PantallaEntity obj) {
		if(obj!= null){
			try {
				pantallaPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PantallaEntity obj) {
		if(obj!= null){
			try {
				pantallaPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public PantallaEntity load(Integer idpantalla) {
		try{
			return pantallaPersistence.load( idpantalla );
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<PantallaEntity> loadAll() {		
		try {
			return pantallaPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
