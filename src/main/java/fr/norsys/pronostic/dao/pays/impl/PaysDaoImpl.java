package fr.norsys.pronostic.dao.pays.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class PaysDaoImpl implements PaysDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaysDaoImpl.class);

	private static final String SELECT_QUERY = " SELECT ID_PAYS,NOM,LOGO FROM PAYS WHERE ID_PAYS = ?";
	private static final String SELECT_PAYS_FROM_POULE = " SELECT  pa.ID_PAYS , pa.NOM  , pa.LOGO from PAYS pa 	 INNER JOIN POULE_PAYS pp on pp.ID_PAYS = pa.ID_PAYS  INNER JOIN POULE po on po.ID_POULE = pp.ID_POULE  WHERE po.ID_POULE = ? ";

	@Autowired
	private DataSource dataSource;

	@Override
	public int create(Pays model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Pays model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Pays> getById(Long id) throws DaoException {

		PreparedStatement preparedStatement;
		ResultSet rs;
		Pays pays;
		Connection connection = null;

		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_QUERY, false, id);
			rs = preparedStatement.executeQuery();
			rs.next();
			pays = new Pays(rs.getLong("ID_PAYS"), rs.getString("NOM"), rs.getString("LOGO"));

		} catch (SQLException e) {
			throw new DaoException("getByID Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}
		return Optional.ofNullable(pays);
	}

	@Override
	public void delete(Pays model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Pays> getPaysByPoule(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		List<Pays> pays = new ArrayList<>();
		Connection connection = null;

		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_PAYS_FROM_POULE, false, id);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				pays.add(new Pays(rs.getLong("ID_PAYS"), rs.getString("NOM"), rs.getString("LOGO")));
			}

		} catch (Exception e) {
			throw new DaoException("getAllPaysByPoule Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}

		return pays;
	}
}
