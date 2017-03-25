package fr.norsys.pronostic.service.salarie.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.salarie.SalarieService;

public class SalarieServiceImpl implements SalarieService {

	@Autowired
	SalarieDao salarieDao;

	public SalarieServiceImpl(SalarieDao salarieDao) {
		this.salarieDao = salarieDao;
	}

	@Override
	public Optional<Salarie> getSalariebyId(Long id) throws DataServiceException {
		try {
			return this.salarieDao.getById(id);
		} catch (DaoException e) {
			throw new DataServiceException("Error get salarie by id Service", e);
		}
	}

	@Override
	public Optional<Salarie> getSalariebyUsername(String name) throws DataServiceException {
		try {
			return this.salarieDao.getSalarieByUsername(name);
		} catch (DaoException e) {
			throw new DataServiceException("Error get salarie by username Service", e);
		}
	}
}
