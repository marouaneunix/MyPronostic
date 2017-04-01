package fr.norsys.pronostic.dao.pays.impl;

import java.util.List;
import java.util.Optional;

import fr.norsys.pronostic.dao.AbstractJpaDAO;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.domain.Pays;

@Repository
public class PaysDaoImpl extends AbstractJpaDAO<Pays> implements PaysDao {




	public PaysDaoImpl() {
		setClazz(Pays.class);
	}

	@Override
	public Optional<Pays> getById(Long id)  {
		return this.findOne(id);
	}



	@Override
	public List<Pays> getPaysByPoule(Long id)   {
		return this.entityManager.createQuery("Select p.payss from Poule as p where p.id = :idPoule").setParameter("idPoule",id).getResultList();
	}
}
