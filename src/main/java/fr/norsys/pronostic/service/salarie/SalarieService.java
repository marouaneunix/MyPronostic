package fr.norsys.pronostic.service.salarie;

import java.util.Optional;

import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DataServiceException;

public interface SalarieService {

	Optional<Salarie> getSalariebyId(Long id) throws DataServiceException;

	Optional<Salarie> getSalariebyUsername(String name) throws DataServiceException;

}
