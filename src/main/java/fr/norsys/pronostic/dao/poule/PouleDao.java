package fr.norsys.pronostic.dao.poule;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface PouleDao extends IDAO<Poule> {

	List<Poule> getAllPoulesByCompetitionId(Long id) throws DaoException;
}
