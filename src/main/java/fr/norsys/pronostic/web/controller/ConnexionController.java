package fr.norsys.pronostic.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.norsys.pronostic.utils.AuthenticationUtil;

@Controller
public class ConnexionController {

	private static final String CONNEXION_VIEW = "connexion";
	private static final String REDIRECTION_URL = "redirect:/connexion?logout";

	@GetMapping("/connexion")
	public String getConnexion() {
		return CONNEXION_VIEW;
	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = AuthenticationUtil.getAuthenticatedUser();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return REDIRECTION_URL;
	}

}
