package org.salondeventas.server.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.salondeventas.server.modelo.jpa.ProductoEntity;

public interface IProductoDAO {
    
	@Transactional
	List<ProductoEntity> getAll();

	@Transactional
	void save(ProductoEntity entity);

	@Transactional
	void update(ProductoEntity entity);

	@Transactional
	void delete(ProductoEntity entity);

	@Transactional
	ProductoEntity get(Long id);
}