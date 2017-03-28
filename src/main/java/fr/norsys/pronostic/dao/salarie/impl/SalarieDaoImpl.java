package fr.norsys.pronostic.dao.salarie.impl;


import java.util.Optional;



import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.mappers.salarie.SalarieMapper;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;


@Repository
public class SalarieDaoImpl extends JdbcConfig implements SalarieDao {


	private static final String SELECT = "SELECT sa.ID_SALARIE,sa.NOM, sa.PRENOM, sa.USERNAME,sa.PASSWORD, ro.ID_ROLE, ro.NOM as ROLE_NOM  FROM SALARIE sa " +
			"LEFT JOIN ROLE ro on ro.ID_ROLE = sa.ID_ROLE ";
	private static final String GET_BY_USERNAME_QUERY = SELECT+"WHERE sa.USERNAME  = ?";
	private static final String GET_BY_ID_QUERY =  SELECT+"WHERE sa.ID_SALARIE  = ?";



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
		Salarie salarie = null;
		try {
			salarie = this.jdbcTemplate.queryForObject(GET_BY_ID_QUERY,new Object[]{id},new SalarieMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new DaoException("getById SQLException ", e);
		}

		return Optional.ofNullable(salarie);
	}

	@Override
	public void delete(Salarie model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Salarie> getSalarieByUsername(String username) throws DaoException {
		Salarie salarie = null;
		try {
			salarie = this.jdbcTemplate.queryForObject(GET_BY_USERNAME_QUERY,new Object[]{username},new SalarieMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new DaoException("getById SQLException ", e);
		}

		return Optional.ofNullable(salarie);
	}


}
