
package org.salondeventas.server.services.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.salondeventas.server.modelo.jpa.PrecioproductoEntityKey;
import org.salondeventas.server.services.PrecioproductoService;
import org.salondeventas.server.services.persistence.PrecioproductoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("precioproductoService")
public class PrecioproductoServiceImpl implements PrecioproductoService {
	
	@Autowired
	private PrecioproductoPersistence precioproductoPersistence;

	public boolean insert(PrecioproductoEntity obj) {
		if(obj!= null){
			try {
				precioproductoPersistence.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean update(PrecioproductoEntity obj) {
		if(obj!= null){
			try {
				precioproductoPersistence.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(PrecioproductoEntity obj) {
		if(obj!= null){
			try {
				precioproductoPersistence.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}	

	public PrecioproductoEntity load(Integer idprecioproducto, Integer idproducto) {
		try{
		// Build the composite key
		PrecioproductoEntityKey key = new PrecioproductoEntityKey( idprecioproducto, idproducto );
			return precioproductoPersistence.load(key);
		}catch (Exception e) {
			return null;
		}		
	}
	
	public List<PrecioproductoEntity> loadAll() {		
		try {
			return precioproductoPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public PrecioproductoEntity load(PrecioproductoEntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}
}
