package fr.norsys.pronostic.dao.poule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.mappers.poule.PouleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class PouleDaoImpl extends JdbcConfig implements PouleDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PouleDaoImpl.class);

	private static final String SELECT_ALL_BY_COMPETITON = "SELECT po.ID_POULE,po.NOM NOM_POULE,po.GROUPE, co.ID_COMPETITION, co.NOM, co.ANNEE FROM POULE po\n" +
														   "left join COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION\n" +
															"where co.ID_COMPETITION = ?;";
	private static final String SELECT_BY_ID = "SELECT po.ID_POULE,po.NOM NOM_POULE,po.GROUPE, co.ID_COMPETITION, co.NOM, co.ANNEE FROM POULE po\n" +
			 								   "left join COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION\n" +
											   "where po.ID_POULE = ?";



	@Autowired
	private CompetitionDao competitionDao;


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
		Poule poule = null;
		try{
			poule = this.jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, new PouleMapper());
		}catch (EmptyResultDataAccessException e){
			throw new DaoException("no poule found ",e);
		}
		return Optional.ofNullable(poule);
	}



	@Override
	public void delete(Poule model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Poule> getAllPoulesByCompetitionId(Long id) {
		return this.jdbcTemplate.query(SELECT_ALL_BY_COMPETITON, new Object[]{id}, new PouleMapper());
	}
}
