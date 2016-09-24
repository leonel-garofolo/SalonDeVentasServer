package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.IPrecioproductoDAO;
import org.salondeventas.server.modelo.jpa.PrecioproductoEntity;
import org.springframework.stereotype.Service;

@Service("precioproductoDao")
public class PrecioproductoDAO extends GenericDAOWithHibernate<PrecioproductoEntity, Long> implements IPrecioproductoDAO {	
		
}
