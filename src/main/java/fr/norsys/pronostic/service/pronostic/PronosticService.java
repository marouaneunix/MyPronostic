package fr.norsys.pronostic.service.pronostic;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DataServiceException;

@Transactional
@Service
public interface PronosticService {

	void create(Pronostic pronostic) throws DataServiceException;

	List<Pronostic> getAllBySalarieId(Long id) throws DataServiceException;

}
