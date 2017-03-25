package fr.norsys.pronostic.dao.rencontre.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.rencontre.RencontreDao;

public abstract class ARencontreTest extends ADaoTest {

	@Autowired
	protected RencontreDao rencontreDao;
}
