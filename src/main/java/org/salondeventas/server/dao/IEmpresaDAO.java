package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.EmpresaEntity;

public interface IEmpresaDAO {
    
	@Transactional
	List<EmpresaEntity> getAll();

	@Transactional
	void save(EmpresaEntity entity);

	@Transactional
	void update(EmpresaEntity entity);

	@Transactional
	void delete(EmpresaEntity entity);

	@Transactional
	EmpresaEntity get(Long id);
}