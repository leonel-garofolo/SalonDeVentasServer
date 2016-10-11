package org.salondeventas.server.services;

import java.util.List;

import org.salondeventas.server.modelo.jpa.VproductosEntity;

public interface VproductosService {

	public List<VproductosEntity> loadAll();
}
