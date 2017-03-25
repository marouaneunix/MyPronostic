package fr.norsys.pronostic.dao.salarie.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.role.RoleDao;
import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class SalarieDaoImpl implements SalarieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(SalarieDaoImpl.class);

	private static final String GET_BY_USERNAME_QUERY = "SELECT ID_SALARIE,NOM, PRENOM, USERNAME, PASSWORD, ID_ROLE FROM SALARIE WHERE USERNAME  = ?";
	private static final String GET_BY_ID_QUERY = "SELECT ID_SALARIE,NOM, PRENOM, USERNAME, PASSWORD, ID_ROLE FROM SALARIE WHERE ID_SALARIE  = ?";

	@Autowired
	DataSource dataSource;

	@Autowired
	RoleDao roleDao;

	@Override
	public int create(Salarie model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Salarie model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Salarie> getById(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		Optional<Salarie> salarie = null;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, GET_BY_ID_QUERY, false, id);
			salarie = this.getSalarie(preparedStatement, connection);
		} catch (SQLException e) {
			throw new DaoException("getById SQLException ", e);
		}

		return salarie;
	}

	@Override
	public void delete(Salarie model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Salarie> getSalarieByUsername(String username) throws DaoException {
		PreparedStatement preparedStatement;
		Optional<Salarie> salarie = null;
		Connection connection = null;

		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, GET_BY_USERNAME_QUERY, false,
					username);
			salarie = this.getSalarie(preparedStatement, connection);
		} catch (SQLException e) {
			throw new DaoException("getSalarieByUserName  SQLException ", e);

		}

		return salarie;
	}

	private Optional<Salarie> getSalarie(PreparedStatement preparedStatement, Connection connection)
			throws DaoException {
		ResultSet rs;
		Salarie salarie;
		try {
			rs = preparedStatement.executeQuery();
			rs.next();
			salarie = new Salarie(rs.getLong("ID_SALARIE"), rs.getString("NOM"), rs.getString("PRENOM"),
					rs.getString("USERNAME"), rs.getString("PASSWORD"),
					this.roleDao.getById(rs.getLong("ID_ROLE")).get(), null);
		} catch (SQLException e) {
			throw new DaoException("Salarie not found SQLException ", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}

		return Optional.ofNullable(salarie);
	}
}
