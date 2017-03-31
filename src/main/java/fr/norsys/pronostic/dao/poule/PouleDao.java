package fr.norsys.pronostic.dao.poule;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.domain.Poule;

@Repository
public interface PouleDao  {

	List getAllPoulesByCompetitionId(Long id);
	Optional<Poule> getById(Long id);
}
