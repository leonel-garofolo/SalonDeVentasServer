package org.salondeventas.server.servicio;

import java.util.List;

import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.salondeventas.server.modelo.jpa.VproductosEntity;

public interface IProductoServicio extends IServicio<ProductoEntity, java.lang.Long>{
	public List<VproductosEntity> obtenerTodosVista();
}
