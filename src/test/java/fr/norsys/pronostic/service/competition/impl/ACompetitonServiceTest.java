package fr.norsys.pronostic.service.competition.impl;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.service.competition.CompetitionService;

/**
 * Created by mar1 on 3/19/17.
 */
public abstract class ACompetitonServiceTest {

	protected CompetitionService competitionService;

	@Mock
	protected CompetitionDao mockCompetionDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.competitionService = new CompetitionServiceImpl(this.mockCompetionDAO);
	}

}
