package org.salondeventas.server.servicio.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.salondeventas.server.dao.IProductoDAO;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productoServicio")
public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private IProductoDAO productoDao;

	public boolean agregar(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoDao.save(obj);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	
	public boolean borrar(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoDao.delete(obj);
			} catch (Exception e) {
				return false;
			}
		}			
		return true;
	}

	
	public ProductoEntity obtener(long id) {
		if(id != 0){
			try{
				return productoDao.get(id);
			}catch (Exception e) {
			}
		}
		return null;
	}

	
	public boolean actualizar(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoDao.update(obj);
			} catch (Exception e) {
				return false;
			}
		}		
		return true;		
	}

	
	public List<ProductoEntity> obtenerTodos() {		
		try {
			return productoDao.getAll();
		} catch (Exception e) {
		}
		return null;
	}
}
