package fr.norsys.pronostic.dao.role.impl;

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
import fr.norsys.pronostic.domain.Role;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class RoleDaoImpl implements RoleDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);

	private static final String SELECT_QUERY = "SELECT ID_ROLE,NOM FROM ROLE WHERE ID_ROLE = ?";

	@Autowired
	DataSource dataSource;

	@Override
	public int create(Role model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Role model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Role> getById(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Connection connection = null;
		Role role;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_QUERY, false, id);
			rs = preparedStatement.executeQuery();
			rs.next();

			role = new Role(rs.getLong("ID_ROLE"), rs.getString("NOM"));

		} catch (SQLException e) {
			throw new DaoException("getByIDPoule Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}
		return Optional.ofNullable(role);
	}

	@Override
	public void delete(Role model) throws DaoException {
		throw new UnsupportedOperationException();
	}
}
