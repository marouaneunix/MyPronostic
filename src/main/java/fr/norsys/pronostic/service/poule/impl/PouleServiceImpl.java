package fr.norsys.pronostic.service.poule.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.poule.PouleService;

@Transactional
@Service
public class PouleServiceImpl implements PouleService {

	@Autowired
	private PouleDao pouleDao;

	public PouleServiceImpl() {
	}

	public PouleServiceImpl(PouleDao pouleDao) {
		this.pouleDao = pouleDao;
	}

	@Override
	public Optional<Poule> getPoulebyId(Long id) throws DataServiceException {
		try {
			return this.pouleDao.getById(id);
		} catch (DaoException e) {
			// TODO: insert message
			throw new DataServiceException("", e);
		}
	}

	@Override
	public List<Poule> getAllPouleByIdCompetiton(Long id) throws DataServiceException {
		try {
			return this.pouleDao.getAllPoulesByCompetitionId(id);
		} catch (DaoException e) {
			// TODO: insert message
			throw new DataServiceException("", e);
		}
	}
}
