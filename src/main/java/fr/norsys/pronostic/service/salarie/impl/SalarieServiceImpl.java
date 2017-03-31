package fr.norsys.pronostic.service.salarie.impl;


import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.service.salarie.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.OptionalDouble;

@Transactional
public class SalarieServiceImpl implements SalarieService {

	@Autowired
	SalarieDao salarieDao;

	public SalarieServiceImpl(SalarieDao salarieDao) {
		this.salarieDao = salarieDao;
	}

	@Override
	public  Optional<Salarie> getSalariebyId(Long id)   {
			return this.salarieDao.getById(id);
	}

	@Override
	public Optional<Salarie> getSalariebyUsername(String name)   {
			return this.salarieDao.getSalarieByUsername(name);
	}
}
