package fr.norsys.pronostic.service.pays.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.pays.PaysService;

@Transactional
@Service
public class PaysServiceImpl implements PaysService {

	@Autowired
	PaysDao paysDao;

	public PaysServiceImpl() {
	}

	public PaysServiceImpl(PaysDao paysDao) {
		this.paysDao = paysDao;
	}

	@Override
	public Optional<Pays> getPaysbyId(Long id) throws DataServiceException {
		try {
			return this.paysDao.getById(id);
		} catch (DaoException e) {
			// TODO: insert message
			throw new DataServiceException("", e);
		}
	}

	@Override
	public List<Pays> getPaysByIdPoule(Long id) throws DataServiceException {
		try {
			return this.paysDao.getPaysByPoule(id);
		} catch (DaoException e) {
			// TODO: insert message
			throw new DataServiceException("", e);
		}
	}
}
