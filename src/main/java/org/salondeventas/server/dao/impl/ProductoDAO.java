package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.IProductoDAO;
import org.salondeventas.server.modelo.jpa.ProductoEntity;
import org.springframework.stereotype.Service;

@Service("productoDao")
public class ProductoDAO extends GenericDAOWithHibernate<ProductoEntity, Long> implements IProductoDAO {	
		
}
