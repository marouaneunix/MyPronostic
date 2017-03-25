package fr.norsys.pronostic.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class AuthenticationUtil {

	/**
	 * permet de retourner l'utilisateur authentifier dans l'application
	 *
	 * @return l'utilisateur authentifier
	 */
	public static Authentication getAuthenticatedUser() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
