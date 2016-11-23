
package org.salondeventas.server.services.impl;

import java.util.List;

import org.salondeventas.server.modelo.informe.jpa.VCantProdVendidosEntity;
import org.salondeventas.server.services.VCantProdVendidosService;
import org.salondeventas.server.services.persistence.VCantProdVendidosPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vCantProdVendidosService")
public class VCantProdVendidosServiceImpl implements VCantProdVendidosService {
	
	@Autowired
	private VCantProdVendidosPersistence vCantProdVendidosPersistence;
	
	public List<VCantProdVendidosEntity> loadAll() {		
		try {
			return vCantProdVendidosPersistence.loadAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
