package fr.norsys.pronostic.service.competition;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DataServiceException;

@Transactional
@Service
public interface CompetitionService {

	List<Competition> getAllCompetitions() throws DataServiceException;

	Optional<Competition> getCompetitionById(Long id) throws DataServiceException;
}
