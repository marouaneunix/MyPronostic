package fr.norsys.pronostic.controller.connexion;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.norsys.pronostic.web.controller.connexion.ConnexionController;

public abstract class AConnexionControllerTest {

	@InjectMocks
	protected ConnexionController connexionController;

	protected MockMvc mockMvc;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.connexionController).build();
	}
}
