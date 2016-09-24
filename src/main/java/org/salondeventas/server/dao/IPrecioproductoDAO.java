package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;

public interface IPrecioproductoDAO {
    
	@Transactional
	List<PrecioproductoEntity> getAll();

	@Transactional
	void save(PrecioproductoEntity entity);

	@Transactional
	void update(PrecioproductoEntity entity);

	@Transactional
	void delete(PrecioproductoEntity entity);

	@Transactional
	PrecioproductoEntity get(Long id);
}