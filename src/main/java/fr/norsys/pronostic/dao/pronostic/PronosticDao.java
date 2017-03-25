package fr.norsys.pronostic.dao.pronostic;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface PronosticDao extends IDAO<Pronostic> {

	List<Pronostic> getAllPronosticsBySalarieId(Long id) throws DaoException;

}
