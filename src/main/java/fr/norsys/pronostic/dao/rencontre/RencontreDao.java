package fr.norsys.pronostic.dao.rencontre;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface RencontreDao  {

	List<Rencontre> getAll() ;

	List<Rencontre> getAllByIdPoule(long id)  ;

	List<Rencontre> getAllRencontresNonPronostiquerParPouleID(long idSalarie, long idPoule) ;

	Optional<Rencontre> getById(Long id);

	void updateRencontre(Rencontre rencontre);

}
