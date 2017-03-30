package fr.norsys.pronostic.dao.competition;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface CompetitionDao{

	List<Competition> getAll();
	Optional<Competition> getById(Long id);


}