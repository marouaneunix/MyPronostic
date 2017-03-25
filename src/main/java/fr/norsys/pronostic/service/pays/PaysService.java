package fr.norsys.pronostic.service.pays;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DataServiceException;

@Transactional
@Service
public interface PaysService {

	Optional<Pays> getPaysbyId(Long id) throws DataServiceException;

	List<Pays> getPaysByIdPoule(Long id) throws DataServiceException;
}
