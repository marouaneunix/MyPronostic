package fr.norsys.pronostic.dao.competition.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.mappers.competition.CompetitionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by mar1 on 3/18/17.
 */

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;
import fr.norsys.pronostic.utils.DateFormat;

@Repository
public class CompetitionDaoImpl extends JdbcConfig implements CompetitionDao {

	private static final String SELECT_ALL_COMPETITON_QUERY = "SELECT ID_COMPETITION,NOM,ANNEE FROM COMPETITION";


	private static final String SELECT_BY_ID_QUERY = "SELECT ID_COMPETITION,NOM,ANNEE FROM COMPETITION WHERE ID_COMPETITION = ?";
	private static final Logger LOGGER = LoggerFactory.getLogger(CompetitionDaoImpl.class);





	@Override
	public int create(Competition model) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Competition model) {
		throw new UnsupportedOperationException();
	}







	@Override
	public void delete(Competition model) throws DaoException {
		throw new UnsupportedOperationException();
	}




	/**
	 * SPRING JDBC
	 */

	@Override
	public Optional<Competition> getById(Long id) throws DaoException {
		Competition competition = new Competition();
		try{
			 competition = this.jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY,
					new Object[]{id},
					new CompetitionMapper());
		}catch (EmptyResultDataAccessException e){
			throw  new DaoException("GetByIDV2 exception",e);
		}
		return Optional.ofNullable(competition);
	}

	@Override
	public List<Competition> getAll() throws DaoException {
		return this.jdbcTemplate.query(SELECT_ALL_COMPETITON_QUERY,new CompetitionMapper());
	}





}
