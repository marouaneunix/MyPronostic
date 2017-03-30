package fr.norsys.pronostic.dao.competition.impl;


import java.util.List;
import java.util.Optional;



import fr.norsys.pronostic.dao.AbstractJpaDAO;

import org.springframework.stereotype.Repository;

/**
 * Created by mar1 on 3/18/17.
 */

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.domain.Competition;


@Repository
public class CompetitionDaoImpl extends AbstractJpaDAO<Competition> implements CompetitionDao {

	public CompetitionDaoImpl(){
		super();
		setClazz(Competition.class);
	}
	@Override
	public List<Competition> getAll() {
		return this.findAll();
	}

	@Override
	public Optional<Competition> getById(Long id) {
		return this.findOne(id);
	}
}
