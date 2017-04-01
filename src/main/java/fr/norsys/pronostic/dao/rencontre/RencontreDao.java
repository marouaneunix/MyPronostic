package fr.norsys.pronostic.dao.rencontre;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.domain.Rencontre;

@Repository
public interface RencontreDao  {

	List<Rencontre> getAll() ;

	List getAllByIdPoule(long id)  ;

	List getAllRencontresNonPronostiquerParPouleID(long idSalarie, long idPoule) ;

	Optional<Rencontre> getById(Long id);


}
