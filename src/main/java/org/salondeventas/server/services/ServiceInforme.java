package org.salondeventas.server.services;

import java.io.Serializable;
import java.util.List;

public interface ServiceInforme<T, ID extends Serializable> {
	public List<T> loadAll();
}