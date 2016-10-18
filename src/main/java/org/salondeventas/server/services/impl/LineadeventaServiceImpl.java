
package org.salondeventas.server.services.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.salondeventas.server.modelo.jpa.LineadeventaEntityKey;
import org.salondeventas.server.services.LineadeventaService;
import org.salondeventas.server.services.persistence.LineadeventaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lineadeventaService")
public class LineadeventaServiceImpl implements LineadeventaService {
	
	@Autowired
	private LineadeventaPersistence lineadeventaPersistence;

	public boolean insert(LineadeventaEntity obj) {
		if(obj!= null){
			try {
				lineadeventaPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(LineadeventaEntity obj) {
		if(obj!= null){
			try {
				lineadeventaPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(LineadeventaEntity obj) {
		if(obj!= null){
			try {
				lineadeventaPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public LineadeventaEntity load(Integer idlineadeventa, Integer idproducto, Integer idventa) {
		try{
			// Build the composite key
			LineadeventaEntityKey key = new LineadeventaEntityKey( idlineadeventa, idproducto, idventa );
			return lineadeventaPersistence.load(key);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<LineadeventaEntity> loadAll() {		
		try {
			return lineadeventaPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LineadeventaEntity load(LineadeventaEntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}
}
