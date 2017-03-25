package fr.norsys.pronostic.dao.poule.impl;

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

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class PouleDaoImpl implements PouleDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PouleDaoImpl.class);

	private static final String SELECT_ALL_BY_COMPETITON = "SELECT * FROM POULE WHERE ID_COMPETITION = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM POULE WHERE ID_POULE = ?";

	@Autowired
	private CompetitionDao competitionDao;

	@Autowired
	private DataSource dataSource;

	@Override
	public int create(Poule model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Poule model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Poule> getById(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Poule poule;
		Connection connection = null;

		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_BY_ID, false, id);
			rs = preparedStatement.executeQuery();

			rs.next();
			poule = new Poule(rs.getLong("ID_POULE"), rs.getString("NOM"), rs.getBoolean("GROUPE"),
					this.competitionDao.getById(rs.getLong("ID_COMPETITION")).get());

		} catch (Exception e) {
			throw new DaoException("getID  Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}

		return Optional.ofNullable(poule);
	}

	@Override
	public void delete(Poule model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Poule> getAllPoulesByCompetitionId(Long id) throws DaoException {

		PreparedStatement preparedStatement;
		ResultSet rs;
		Connection connection = null;

		List<Poule> poules = new ArrayList<>();
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_ALL_BY_COMPETITON, false, id);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				poules.add(new Poule(rs.getLong("ID_POULE"), rs.getString("NOM"), rs.getBoolean("GROUPE"),
						this.competitionDao.getById(rs.getLong("ID_COMPETITION")).get()));
			}

		} catch (Exception e) {
			throw new DaoException("getAll Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}

		return poules;
	}
}
