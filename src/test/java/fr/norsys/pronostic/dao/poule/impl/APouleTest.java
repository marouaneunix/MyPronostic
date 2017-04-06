package fr.norsys.pronostic.dao.poule.impl;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.dao.poule.PouleDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class APouleTest extends ADaoTest {

	@Autowired
	protected PouleDao pouleDao;

	@Autowired
	protected CompetitionDao competitionDao;

	@Autowired
	protected PaysDao paysDao;
}
