package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.IVentaDAO;
import org.salondeventas.server.modelo.jpa.VentaEntity;
import org.springframework.stereotype.Service;

@Service("ventaDao")
public class VentaDAO extends GenericDAOWithHibernate<VentaEntity, Long> implements IVentaDAO {	
		
}
