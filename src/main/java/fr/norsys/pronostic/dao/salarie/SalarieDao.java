package fr.norsys.pronostic.dao.salarie;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface SalarieDao extends IDAO<Salarie> {

	Optional<Salarie> getSalarieByUsername(String username) throws DaoException;

}
