package fr.norsys.pronostic.dao.pronostic.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.pronostic.PronosticDao;

public abstract class APronosticTest extends ADaoTest {

	@Autowired
	PronosticDao pronosticDao;

}
