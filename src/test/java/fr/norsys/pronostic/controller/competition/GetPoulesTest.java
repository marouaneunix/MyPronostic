package fr.norsys.pronostic.controller.competition;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;

public class GetPoulesTest extends ACompetitionControllerTest {

	@Test
	public void shouldReturnPouleView() throws Exception {
		doReturn(Optional.ofNullable(new Competition())).when(this.competitionService).getCompetitionById(1L);

		this.mockMvc.perform(get("/competition/{id}", 1L)).andExpect(status().isOk())
				.andExpect(view().name("salarie/poule"));

		verify(this.competitionService, times(1)).getCompetitionById(1L);
	}

}
