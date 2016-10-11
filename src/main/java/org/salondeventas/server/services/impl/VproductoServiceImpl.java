
package org.salondeventas.server.services.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.VproductosEntity;
import org.salondeventas.server.services.VproductosService;
import org.salondeventas.server.services.persistence.VProductoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vproductoService")
public class VproductoServiceImpl implements VproductosService{
	
	@Autowired
	private VProductoPersistence vproductoPersistence;
	
	public List<VproductosEntity> loadAll() {		
		try {
			return vproductoPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
