package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.LicenciasEntity;

public interface ILicenciasDAO {
    
	@Transactional
	List<LicenciasEntity> getAll();

	@Transactional
	void save(LicenciasEntity entity);

	@Transactional
	void update(LicenciasEntity entity);

	@Transactional
	void delete(LicenciasEntity entity);

	@Transactional
	LicenciasEntity get(Long id);
}