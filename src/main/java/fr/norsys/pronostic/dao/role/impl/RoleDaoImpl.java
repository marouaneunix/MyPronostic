package fr.norsys.pronostic.dao.role.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.mappers.role.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.role.RoleDao;
import fr.norsys.pronostic.domain.Role;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class RoleDaoImpl extends JdbcConfig implements RoleDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);

	private static final String SELECT_QUERY = "SELECT ID_ROLE,NOM FROM ROLE WHERE ID_ROLE = ?";



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

		Role role;
		try {
			role = this.jdbcTemplate.queryForObject(SELECT_QUERY,new Object[]{id},new RoleMapper());

		} catch (EmptyResultDataAccessException e) {
			throw new DaoException("getByIDRole Not working SQLException", e);
		}
		return Optional.ofNullable(role);
	}

	@Override
	public void delete(Role model) throws DaoException {
		throw new UnsupportedOperationException();
	}
}
