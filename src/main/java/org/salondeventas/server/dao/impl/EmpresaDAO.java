package org.salondeventas.server.dao.impl;

import org.salondeventas.server.dao.GenericDAOWithHibernate;
import org.salondeventas.server.dao.IEmpresaDAO;
import org.salondeventas.server.modelo.jpa.EmpresaEntity;
import org.springframework.stereotype.Service;

@Service("empresaDao")
public class EmpresaDAO extends GenericDAOWithHibernate<EmpresaEntity, Long> implements IEmpresaDAO {	
		
}
