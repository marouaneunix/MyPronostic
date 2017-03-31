package fr.norsys.pronostic.controller.connexion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.pronostic.web.controller.connexion.ConnexionController;

public class GetConnexionTest {

	ConnexionController connexionController;

	@Before
	public void setUp() {
		this.connexionController = new ConnexionController();
	}

	@Test
	public void testreturnedViewName() {
		String viewName = this.connexionController.getConnexion();
		assertThat(viewName).isEqualTo("connexion");
	}

}
