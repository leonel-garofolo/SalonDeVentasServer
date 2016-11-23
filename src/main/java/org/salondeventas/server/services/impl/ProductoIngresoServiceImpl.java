
package org.salondeventas.server.services.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.services.persistence.ProductoIngresoPersistence;
import org.salondeventas.server.modelo.jpa.ProductoIngresoEntity;
import org.salondeventas.server.services.ProductoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productoIngresoService")
public class ProductoIngresoServiceImpl implements ProductoIngresoService {
	
	@Autowired
	private ProductoIngresoPersistence productoIngresoPersistence;

	public boolean insert(ProductoIngresoEntity obj) {
		if(obj!= null){
			try {
				productoIngresoPersistence.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean update(ProductoIngresoEntity obj) {
		if(obj!= null){
			try {
				productoIngresoPersistence.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}
	
	public boolean delete(ProductoIngresoEntity obj) {
		if(obj!= null){
			try {
				productoIngresoPersistence.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}	

	public ProductoIngresoEntity load(Integer idproductoIngreso, Integer idproducto) {
		try{
			return productoIngresoPersistence.load( idproductoIngreso, idproducto );	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<ProductoIngresoEntity> loadAll() {		
		try {
			return productoIngresoPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
