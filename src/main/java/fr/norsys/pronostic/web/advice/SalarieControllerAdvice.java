package fr.norsys.pronostic.web.advice;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.norsys.pronostic.domain.Salarie;

@ControllerAdvice
public class SalarieControllerAdvice {

	/**
	 * permet de stocker l'utilisateur courant dans un model currentUser pour
	 * l'utilisé dans les page html
	 *
	 * @param authentication
	 * @return
	 */
	@ModelAttribute("currentUser")
	public Salarie getCurrentUser(Authentication authentication) {
		return authentication == null ? null : (Salarie) authentication.getPrincipal();
	}
}
