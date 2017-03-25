package fr.norsys.pronostic.dao.poule.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.poule.PouleDao;

public abstract class APouleTest extends ADaoTest {

	@Autowired
	protected PouleDao pouleDao;
}
