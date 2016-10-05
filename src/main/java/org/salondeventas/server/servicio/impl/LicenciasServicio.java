package org.salondeventas.server.servicio.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.LicenciasEntity;
import org.salondeventas.server.persistence.services.LicenciasPersistence;
import org.salondeventas.server.servicio.ILicenciasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("licenciasServicio")
public class LicenciasServicio implements ILicenciasServicio {
	
	@Autowired
	private LicenciasPersistence licenciasDao;

	public boolean agregar(LicenciasEntity obj) {
		if(obj!= null){
			try {
				licenciasDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(LicenciasEntity obj) {
		if(obj!= null){
			try {
				licenciasDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public LicenciasEntity obtener(long id) {
		if(id != 0){
			try{
				return licenciasDao.load((int)id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(LicenciasEntity obj) {
		if(obj!= null){
			try {
				licenciasDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<LicenciasEntity> obtenerTodos() {		
		try {
			return licenciasDao.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
