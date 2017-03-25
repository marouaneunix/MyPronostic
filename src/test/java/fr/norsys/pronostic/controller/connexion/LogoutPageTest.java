package fr.norsys.pronostic.controller.connexion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class LogoutPageTest extends AConnexionControllerTest {

	@Test
	public void shouldReturnViewCompetition() throws Exception {
		this.mockMvc.perform(get("/logout")).andExpect(status().is(302)).andExpect(redirectedUrl("/connexion?logout"));
	}
}
