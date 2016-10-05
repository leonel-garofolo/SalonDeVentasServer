package org.salondeventas.server.servicio.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.salondeventas.server.persistence.services.PrecioproductoPersistence;
import org.salondeventas.server.servicio.IPrecioproductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("precioproductoServicio")
public class PrecioproductoServicio implements IPrecioproductoServicio {
	
	@Autowired
	private PrecioproductoPersistence precioproductoDao;

	public boolean agregar(PrecioproductoEntity obj) {
		if(obj!= null){
			try {
				precioproductoDao.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(PrecioproductoEntity obj) {
		if(obj!= null){
			try {
				precioproductoDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public PrecioproductoEntity obtener(long id) {
		if(id != 0){
			try{
				return precioproductoDao.load((int)id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(PrecioproductoEntity obj) {
		if(obj!= null){
			try {
				precioproductoDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<PrecioproductoEntity> obtenerTodos() {		
		try {
			return precioproductoDao.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
