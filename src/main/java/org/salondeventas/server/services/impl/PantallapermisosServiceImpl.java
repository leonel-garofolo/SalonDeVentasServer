
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.PantallapermisosPersistence;
import org.salondeventas.server.modelo.jpa.PantallapermisosEntity;
import org.salondeventas.server.services.PantallapermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pantallapermisosService")
public class PantallapermisosServiceImpl implements PantallapermisosService {
	
	@Autowired
	private PantallapermisosPersistence pantallapermisosPersistence;

	public boolean insert(PantallapermisosEntity obj) {
		if(obj!= null){
			try {
				pantallapermisosPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(PantallapermisosEntity obj) {
		if(obj!= null){
			try {
				pantallapermisosPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PantallapermisosEntity obj) {
		if(obj!= null){
			try {
				pantallapermisosPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public PantallapermisosEntity load(Integer idpantalla, String idpermiso) {
		try{
			return pantallapermisosPersistence.load( idpantalla, idpermiso );	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<PantallapermisosEntity> loadAll() {		
		try {
			return pantallapermisosPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
