package fr.norsys.pronostic.service.poule;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DataServiceException;

@Transactional
@Service
public interface PouleService {

	Optional<Poule> getPoulebyId(Long id) throws DataServiceException;

	List<Poule> getAllPouleByIdCompetiton(Long id) throws DataServiceException;
}
