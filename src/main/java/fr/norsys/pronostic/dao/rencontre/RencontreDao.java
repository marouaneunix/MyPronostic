package fr.norsys.pronostic.dao.rencontre;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface RencontreDao extends IDAO<Rencontre> {

	List<Rencontre> getAll() ;

	List<Rencontre> getAllByIdPoule(long id)  ;

	List<Rencontre> getAllRencontresNonPronostiquerParPouleID(long idSalarie, long idPoule) ;

}
