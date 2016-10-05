package org.salondeventas.server.servicio.impl;

import java.util.List;

import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.modelo.jpa.VproductosEntity;
import org.salondeventas.server.persistence.services.ProductoPersistence;
import org.salondeventas.server.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productoServicio")
public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private ProductoPersistence productoDao;

	public boolean agregar(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoDao.insert(obj);
			} catch (Exception e) {
				e.printStackTrace();
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
				e.printStackTrace();
				return false;
			}
		}			
		return true;
	}

	
	public ProductoEntity obtener(long id) {
		if(id != 0){
			try{
				return productoDao.load((int)id);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	public boolean actualizar(ProductoEntity obj) {
		if(obj!= null){
			try {
				productoDao.save(obj);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}		
		return true;		
	}

	
	public List<ProductoEntity> obtenerTodos() {		
		try {
			return productoDao.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<VproductosEntity> obtenerTodosVista() {
		try {
			return productoDao.loadAllVista();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
