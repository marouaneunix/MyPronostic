package fr.norsys.pronostic.dao.poule.impl;

import java.util.List;
import java.util.Optional;

import fr.norsys.pronostic.dao.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.domain.Poule;

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

	@Override
	public void createPoule(Poule poule) {
		this.create(poule);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Poule> getAllPoulesByCompetitionId(Long id) {
		return this.entityManager.createQuery("from Poule as p where p.competition.id = :competition_id").setParameter("competition_id",id).getResultList();
	}
}
