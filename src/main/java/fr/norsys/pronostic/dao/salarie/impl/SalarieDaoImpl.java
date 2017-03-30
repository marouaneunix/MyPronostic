package fr.norsys.pronostic.dao.salarie.impl;





import fr.norsys.pronostic.dao.AbstractJpaDAO;



import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;

import java.util.Optional;


@Repository
public class SalarieDaoImpl extends AbstractJpaDAO<Salarie> implements SalarieDao {

	public SalarieDaoImpl() {
		setClazz(Salarie.class);
	}

	@Override
	public Optional<Salarie> getById(Long id)  {
		return this.findOne(id);
	}


	@Override
	public Optional<Salarie> getSalarieByUsername(String username) {
		Optional<Salarie> salarie = Optional.ofNullable((Salarie) this.entityManager.createQuery("from Salarie as s where s.username = :username").setParameter("username",username).getSingleResult());
		return salarie;
	}


}
