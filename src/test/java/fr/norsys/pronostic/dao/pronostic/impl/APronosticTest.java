package fr.norsys.pronostic.dao.pronostic.impl;

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.dao.rencontre.RencontreDao;
import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.pronostic.PronosticDao;

public abstract class APronosticTest extends ADaoTest {

	@Autowired
	PronosticDao pronosticDao;

	@Autowired
	RencontreDao rencontreDao;

	@Autowired
	PouleDao pouleDao;

	@Autowired
	SalarieDao salarieDao;

}
