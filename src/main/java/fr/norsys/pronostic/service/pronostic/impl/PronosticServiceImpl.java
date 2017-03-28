package fr.norsys.pronostic.service.pronostic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.dao.pronostic.PronosticDao;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.pronostic.PronosticService;

@Transactional
@Service
public class PronosticServiceImpl implements PronosticService {

	@Autowired
	PronosticDao pronosticDao;

	public PronosticServiceImpl() {
	}

	public PronosticServiceImpl(PronosticDao pronosticDao) {
		this.pronosticDao = pronosticDao;
	}

	@Override
	public int create(Pronostic pronostic) throws DataServiceException {
		try {
			return this.pronosticDao.create(pronostic);
		} catch (DaoException e) {
			// TODO: insert message
			throw new DataServiceException("", e);
		}
	}

	@Override
	public List<Pronostic> getAllBySalarieId(Long id) throws DataServiceException {

			return this.pronosticDao.getAllPronosticsBySalarieId(id);

	}
}
