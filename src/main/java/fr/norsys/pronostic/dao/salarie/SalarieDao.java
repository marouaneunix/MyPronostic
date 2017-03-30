package fr.norsys.pronostic.dao.salarie;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface SalarieDao  {

	Optional<Salarie> getSalarieByUsername(String username);
	Optional<Salarie> getById(Long id);

}
