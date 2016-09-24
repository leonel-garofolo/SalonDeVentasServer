package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.UsuarioEntity;

public interface IUsuarioDAO {
    
	@Transactional
	List<UsuarioEntity> getAll();

	@Transactional
	void save(UsuarioEntity entity);

	@Transactional
	void update(UsuarioEntity entity);

	@Transactional
	void delete(UsuarioEntity entity);

	@Transactional
	UsuarioEntity get(Long id);
}