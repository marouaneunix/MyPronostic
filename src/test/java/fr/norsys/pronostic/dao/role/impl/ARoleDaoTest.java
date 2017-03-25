package fr.norsys.pronostic.dao.role.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.role.RoleDao;

public abstract class ARoleDaoTest extends ADaoTest {

	@Autowired
	protected RoleDao roleDao;
}
