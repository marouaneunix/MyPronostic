package fr.norsys.pronostic.exception;

/**
 * Exception survenant dans les DAO
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = -2941403965177375498L;

	public DaoException() {
		super();
	}

	/**
	 * DaoException
	 *
	 * @param pMessage
	 * @param pCause
	 */
	public DaoException(final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	}

	public DaoException(final String pMessage) {
		super(pMessage);
	}

	public DaoException(final Throwable pMessage) {
		super(pMessage);
	}

}
