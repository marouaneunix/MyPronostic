package fr.norsys.pronostic.service.rencontre.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.dao.rencontre.RencontreDao;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.rencontre.RencontreService;

/**
 * Created by badouch on 3/20/17.
 */
@Transactional
@Service
public class RencontreServiceImpl implements RencontreService {

	@Autowired
	RencontreDao rencontreDao;

	public RencontreServiceImpl(RencontreDao rencontreDao) {
		this.rencontreDao = rencontreDao;
	}

	@Override
	public List<Rencontre> getAll() throws DataServiceException {

			return this.rencontreDao.getAll();

	}

	@Override
	public Optional<Rencontre> getRencontrebyId(Long id) throws DataServiceException {
		try {
			return this.rencontreDao.getById(id);
		} catch (DaoException e) {
			throw new DataServiceException("Error get rencontre by id Service", e);
		}
	}

	@Override
	public List<Rencontre> getRencontresByIdPoule(Long id) throws DataServiceException {

			return this.rencontreDao.getAllByIdPoule(id);

	}

	@Override
	public List<Rencontre> getRencontresNonPronostiquerByIdPoule(Long idSalarie, Long idPoule)
			throws DataServiceException {

			return this.rencontreDao.getAllRencontresNonPronostiquerParPouleID(idSalarie, idPoule);

	}
}
