package fr.norsys.pronostic.dao.salarie.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.salarie.SalarieDao;

public abstract class ASalarieTest extends ADaoTest {

	@Autowired
	protected SalarieDao salarieDao;
}
