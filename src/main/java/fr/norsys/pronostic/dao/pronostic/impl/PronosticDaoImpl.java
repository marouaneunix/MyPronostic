package fr.norsys.pronostic.dao.pronostic.impl;

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

import fr.norsys.pronostic.dao.pronostic.PronosticDao;
import fr.norsys.pronostic.dao.rencontre.RencontreDao;
import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class PronosticDaoImpl implements PronosticDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PronosticDaoImpl.class);

	private static final String INSERT_QUERY = "INSERT INTO PRONOSTIC (`BUT_1`, `BUT_2`, `NOTE`, `ID_RENCONTRE`, `ID_SALARIE`) VALUES(?,?,?,?,?)";
	private static final String SELECT_ALL_BY_SALARIE_QUERY = "SELECT * FROM PRONOSTIC WHERE ID_SALARIE = ?";

	@Autowired
	private DataSource dataSource;

	@Autowired
	private RencontreDao rencontreDao;

	@Autowired
	private SalarieDao salarieDao;

	@Override
	public List<Pronostic> getAllPronosticsBySalarieId(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Connection connection = null;
		List<Pronostic> pronostics = new ArrayList<>();
		try {
			connection = this.dataSource.getConnection();

			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_ALL_BY_SALARIE_QUERY, false,
					id);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				pronostics.add(new Pronostic(rs.getLong("ID_PRONOSTIC"), rs.getInt("BUT_1"), rs.getInt("BUT_2"),
						rs.getInt("NOTE"), this.rencontreDao.getById(rs.getLong("ID_RENCONTRE")).get(),
						this.salarieDao.getById(rs.getLong("ID_SALARIE")).get()));
			}

		} catch (SQLException e) {
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

		return pronostics;
	}

	@Override
	public int create(Pronostic model) throws DaoException {
		PreparedStatement preparedStatement;
		int rs;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, INSERT_QUERY, false, model.getBut1(),
					model.getBut2(), model.getNote(), model.getRencontre().getId(), model.getSalarie().getId());
			rs = preparedStatement.executeUpdate();

		} catch (SQLException | NullPointerException e) {
			throw new DaoException("create pronostic Error", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public void update(Pronostic model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Pronostic> getById(Long id) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Pronostic model) throws DaoException {
		throw new UnsupportedOperationException();
	}
}
