package org.salondeventas.server.controlador;

import java.io.Serializable;
import java.util.List;

public interface Controller <T, ID extends Serializable> {
	
	public String insert(String usuario, String clave, T entity);
	public String update(String usuario, String clave, T entity);
	public String delete(String usuario, String clave, T entity);	
	public T load(String usuario, String clave, T entity) throws Exception;
	public List<T> loadAll(String usuario, String clave);
}
