package fr.norsys.pronostic.dao.role.impl;


import fr.norsys.pronostic.dao.AbstractJpaDAO;
import fr.norsys.pronostic.dao.role.RoleDao;
import fr.norsys.pronostic.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;





@Repository
public class RoleDaoImpl extends AbstractJpaDAO<Role> implements RoleDao{


	public RoleDaoImpl(){
		super();
			setClazz(Role.class);
	}


	@Override
	public Optional<Role> getById(Long id) {
		return this.findOne(id);
	}
}
