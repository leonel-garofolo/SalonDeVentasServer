package org.salondeventas.server.servicio.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.dao.IEmpresaDAO;
import org.salondeventas.server.modelo.jpa.EmpresaEntity;
import org.salondeventas.server.servicio.IEmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empresaServicio")
public class EmpresaServicio implements IEmpresaServicio {
	
	@Autowired
	private IEmpresaDAO empresaDao;

	public boolean agregar(EmpresaEntity obj) {
		if(obj!= null){
			try {
				empresaDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(EmpresaEntity obj) {
		if(obj!= null){
			try {
				empresaDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public EmpresaEntity obtener(long id) {
		if(id != 0){
			try{
				return empresaDao.get(id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(EmpresaEntity obj) {
		if(obj!= null){
			try {
				empresaDao.update(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<EmpresaEntity> obtenerTodos() {		
		try {
			return empresaDao.getAll();
		} catch (Exception e) {
		}
		return null;
	}
}
