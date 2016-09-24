package org.salondeventas.server.servicio.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.dao.ILineadeventaDAO;
import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.servicio.ILineadeventaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lineadeventaServicio")
public class LineadeventaServicio implements ILineadeventaServicio {
	
	@Autowired
	private ILineadeventaDAO lineadeventaDao;

	public boolean agregar(LineadeventaEntity obj) {
		if(obj!= null){
			try {
				lineadeventaDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(LineadeventaEntity obj) {
		if(obj!= null){
			try {
				lineadeventaDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public LineadeventaEntity obtener(long id) {
		if(id != 0){
			try{
				return lineadeventaDao.get(id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(LineadeventaEntity obj) {
		if(obj!= null){
			try {
				lineadeventaDao.update(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<LineadeventaEntity> obtenerTodos() {		
		try {
			return lineadeventaDao.getAll();
		} catch (Exception e) {
		}
		return null;
	}
}
