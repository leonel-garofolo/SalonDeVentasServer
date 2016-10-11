package org.salondeventas.server.controlador;

import java.util.List;

import org.salondeventas.server.modelo.jpa.VproductosEntity;

public interface VproductosController {
	public List<VproductosEntity> loadAll(String usuario, String clave);
}
