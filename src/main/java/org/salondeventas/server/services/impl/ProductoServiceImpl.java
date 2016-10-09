
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.ProductoPersistence;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoPersistence productoPersistence;

	public boolean insert(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoPersistence.insert(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean update(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoPersistence.save(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoPersistence.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}	

	public ProductoEntity load(Integer idproducto) {
		try{
			return productoPersistence.load( idproducto );
		}catch (Exception e) {
			return null;
		}		
	}
	
	public List<ProductoEntity> loadAll() {		
		try {
			return productoPersistence.loadAll();
		} catch (Exception e) {
		}
		return null;
	}
}
