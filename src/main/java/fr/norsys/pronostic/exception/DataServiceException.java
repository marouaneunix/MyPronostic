package fr.norsys.pronostic.exception;

/**
 * Exception lors d'un appel à la couche service (BDD, etc...).
 *
 *
 */
public final class DataServiceException extends Exception {

	private static final long serialVersionUID = -7974028201660824856L;

	public DataServiceException(String message) {

		super(message);
	}

	public DataServiceException(String message, Exception cause) {

		super(message, cause);
	}

}
