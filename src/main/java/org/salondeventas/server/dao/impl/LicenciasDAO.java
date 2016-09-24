package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.ILicenciasDAO;
import org.salondeventas.server.modelo.jpa.LicenciasEntity;
import org.springframework.stereotype.Service;

@Service("licenciasDao")
public class LicenciasDAO extends GenericDAOWithHibernate<LicenciasEntity, Long> implements ILicenciasDAO {	
		
}
