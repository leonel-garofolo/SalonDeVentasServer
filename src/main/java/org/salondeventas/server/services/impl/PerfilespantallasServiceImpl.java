
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.PerfilespantallasPersistence;
import org.salondeventas.server.modelo.jpa.PerfilespantallasEntity;
import org.salondeventas.server.services.PerfilespantallasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("perfilespantallasService")
public class PerfilespantallasServiceImpl implements PerfilespantallasService {
	
	@Autowired
	private PerfilespantallasPersistence perfilespantallasPersistence;

	public boolean insert(PerfilespantallasEntity obj) {
		if(obj!= null){
			try {
				perfilespantallasPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(PerfilespantallasEntity obj) {
		if(obj!= null){
			try {
				perfilespantallasPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PerfilespantallasEntity obj) {
		if(obj!= null){
			try {
				perfilespantallasPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public PerfilespantallasEntity load(Integer idperfiles, Integer idpantallas) {
		try{
			return perfilespantallasPersistence.load( idperfiles, idpantallas );	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<PerfilespantallasEntity> loadAll() {		
		try {
			return perfilespantallasPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
