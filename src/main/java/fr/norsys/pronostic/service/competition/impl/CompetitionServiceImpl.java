package fr.norsys.pronostic.service.competition.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.competition.CompetitionService;

@Transactional
@Service
public class CompetitionServiceImpl implements CompetitionService {

	@Autowired
	private final CompetitionDao competitionDao;

	public CompetitionServiceImpl(CompetitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}

	@Override
	public List<Competition> getAllCompetitions() throws DataServiceException {
		try {
			return this.competitionDao.getAll();
		} catch (DaoException e) {
			throw new DataServiceException("get All competition service error ", e);
		}
	}

	@Override
	public Optional<Competition> getCompetitionById(Long id) throws DataServiceException {
		try {
			return this.competitionDao.getById(id);
		} catch (DaoException e) {
			throw new DataServiceException("get competition by id error", e);
		}
	}

}
