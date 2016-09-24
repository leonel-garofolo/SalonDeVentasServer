package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.VentaEntity;

public interface IVentaDAO {
    
	@Transactional
	List<VentaEntity> getAll();

	@Transactional
	void save(VentaEntity entity);

	@Transactional
	void update(VentaEntity entity);

	@Transactional
	void delete(VentaEntity entity);

	@Transactional
	VentaEntity get(Long id);
}