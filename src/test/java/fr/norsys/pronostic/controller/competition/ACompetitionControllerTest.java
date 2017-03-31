package fr.norsys.pronostic.controller.competition;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.pronostic.service.competition.CompetitionService;
import fr.norsys.pronostic.service.pays.PaysService;
import fr.norsys.pronostic.service.poule.PouleService;
import fr.norsys.pronostic.web.controller.competition.CompetitionController;

public abstract class ACompetitionControllerTest {

	@InjectMocks
	protected CompetitionController competitionController;

	@Mock
	protected CompetitionService competitionService;

	@Mock
	protected PouleService pouleService;

	@Mock
	protected PaysService paysService;

	protected MockMvc mockMvc;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.competitionController).build();
	}

}
