package org.salondeventas.server.servicio.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.salondeventas.server.persistence.services.VentaPersistence;
import org.salondeventas.server.servicio.IVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ventaServicio")
public class VentaServicio implements IVentaServicio {
	
	@Autowired
	private VentaPersistence ventaDao;

	public boolean agregar(VentaEntity obj) {
		if(obj!= null){
			try {
				ventaDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(VentaEntity obj) {
		if(obj!= null){
			try {
				ventaDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public VentaEntity obtener(long id) {
		if(id != 0){
			try{
				return ventaDao.load((int)id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(VentaEntity obj) {
		if(obj!= null){
			try {
				ventaDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<VentaEntity> obtenerTodos() {		
		try {
			return ventaDao.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
