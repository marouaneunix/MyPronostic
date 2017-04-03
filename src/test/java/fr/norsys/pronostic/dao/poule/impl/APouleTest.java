package fr.norsys.pronostic.dao.poule.impl;

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.domain.Competition;
import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.poule.PouleDao;

public abstract class APouleTest extends ADaoTest {

	@Autowired
	protected PouleDao pouleDao;

	@Autowired
	protected CompetitionDao competitionDao;
}
