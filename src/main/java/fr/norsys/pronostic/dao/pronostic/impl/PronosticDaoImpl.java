package fr.norsys.pronostic.dao.pronostic.impl;

import java.util.List;


import fr.norsys.pronostic.dao.AbstractJpaDAO;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.pronostic.PronosticDao;

import fr.norsys.pronostic.domain.Pronostic;


@Repository
public class PronosticDaoImpl extends AbstractJpaDAO implements PronosticDao {




	public PronosticDaoImpl() {
		setClazz(Pronostic.class);
	}

	@Override
	public List<Pronostic> getAllPronosticsBySalarieId(Long id){
		return this.entityManager.createQuery("from Pronostic as p where p.salarie.id = :idSalarie").setParameter("idSalarie",id).getResultList();
	}


	@Override
	public void createPronostic(Pronostic model)   {
		this.update(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pronostic> getAll() {
		return this.findAll();
	}


}
