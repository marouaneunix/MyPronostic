package fr.norsys.pronostic.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public final class DaoUtils {

	/**
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés
	 *
	 * @param connexion
	 * @param sql
	 * @param returnGeneratedKeys
	 *            : indiquant s'il faut ou non retourner d'éventuelles valeurs
	 *            auto-générées
	 * @param objets
	 *            une succession d'objets... de tailles variables
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	public static PreparedStatement initialisationRequetePreparee(Connection connexion, String sql,
			boolean returnGeneratedKeys, Object... objets) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		for (int i = 0; i < objets.length; i++) {
			preparedStatement.setObject(i + 1, objets[i]);
		}
		return preparedStatement;
	}

}
