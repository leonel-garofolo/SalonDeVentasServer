package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.LineadeventaEntity;

public interface ILineadeventaDAO {
    
	@Transactional
	List<LineadeventaEntity> getAll();

	@Transactional
	void save(LineadeventaEntity entity);

	@Transactional
	void update(LineadeventaEntity entity);

	@Transactional
	void delete(LineadeventaEntity entity);

	@Transactional
	LineadeventaEntity get(Long id);
}