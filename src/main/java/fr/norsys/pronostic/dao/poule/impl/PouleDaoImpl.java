package fr.norsys.pronostic.dao.poule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import fr.norsys.pronostic.dao.AbstractJpaDAO;
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
public class PouleDaoImpl extends AbstractJpaDAO<Poule> implements PouleDao {


	public PouleDaoImpl() {
		setClazz(Poule.class);
	}

	@Autowired
	private CompetitionDao competitionDao;


	@Override
	public Optional<Poule> getById(Long id)  {
		return this.findOne(id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Poule> getAllPoulesByCompetitionId(Long id) {
		return this.entityManager.createQuery("from Poule as p where p.competition.id = :competition_id").setParameter("competition_id",id).getResultList();
	}
}
