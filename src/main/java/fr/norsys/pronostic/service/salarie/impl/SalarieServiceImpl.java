package fr.norsys.pronostic.service.salarie.impl;


import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.service.salarie.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class SalarieServiceImpl implements SalarieService {

	@Autowired
	SalarieDao salarieDao;

	public SalarieServiceImpl(SalarieDao salarieDao) {
		this.salarieDao = salarieDao;
	}

	@Override
	public Salarie getSalariebyId(Long id)   {
			return this.salarieDao.getById(id).get();
	}

	@Override
	public Salarie  getSalariebyUsername(String name)   {
			return this.salarieDao.getSalarieByUsername(name).get();
	}
}
