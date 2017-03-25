package fr.norsys.pronostic.controller.competition;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;

public class GetCompetitionsTest extends ACompetitionControllerTest {

	@Test
	public void shouldReturnViewCompetition() throws Exception {
		List<Competition> competitions = Arrays.asList(new Competition(), new Competition());
		doReturn(competitions).when(this.competitionService).getAllCompetitions();
		this.mockMvc.perform(get("/competition")).andExpect(status().isOk())
				.andExpect(view().name("salarie/competition"));
		verify(this.competitionService, times(1)).getAllCompetitions();
	}

}
