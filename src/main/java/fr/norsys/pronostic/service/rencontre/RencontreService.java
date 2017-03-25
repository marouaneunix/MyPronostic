package fr.norsys.pronostic.service.rencontre;

import java.util.List;
import java.util.Optional;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DataServiceException;

public interface RencontreService {

	List<Rencontre> getAll() throws DataServiceException;

	Optional<Rencontre> getRencontrebyId(Long id) throws DataServiceException;

	List<Rencontre> getRencontresByIdPoule(Long id) throws DataServiceException;

	List<Rencontre> getRencontresNonPronostiquerByIdPoule(Long idSalarie, Long idPoule) throws DataServiceException;

}
