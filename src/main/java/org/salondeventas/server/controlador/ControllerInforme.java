package org.salondeventas.server.controlador;

import java.io.Serializable;
import java.util.List;

public interface ControllerInforme <T, ID extends Serializable> {
		
	public T load(String usuario, String clave, T entity);
	public List<T> loadAll(String usuario, String clave);
}
