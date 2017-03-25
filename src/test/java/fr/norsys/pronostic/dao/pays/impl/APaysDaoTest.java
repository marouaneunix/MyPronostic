package fr.norsys.pronostic.dao.pays.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.pays.PaysDao;

public abstract class APaysDaoTest extends ADaoTest {

	@Autowired
	protected PaysDao paysDao;
}
