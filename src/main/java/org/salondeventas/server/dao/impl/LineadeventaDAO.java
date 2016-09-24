package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.ILineadeventaDAO;
import org.salondeventas.server.modelo.jpa.LineadeventaEntity;
import org.springframework.stereotype.Service;

@Service("lineadeventaDao")
public class LineadeventaDAO extends GenericDAOWithHibernate<LineadeventaEntity, Long> implements ILineadeventaDAO {	
		
}
