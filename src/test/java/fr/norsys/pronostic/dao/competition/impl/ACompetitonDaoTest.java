package fr.norsys.pronostic.dao.competition.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.ADaoTest;
import fr.norsys.pronostic.dao.competition.CompetitionDao;

public abstract class ACompetitonDaoTest extends ADaoTest {

	@Autowired
	protected CompetitionDao competitionDao;

}
