package fr.norsys.pronostic.dao.pays;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface PaysDao extends IDAO<Pays> {

	List<Pays> getPaysByPoule(Long id) throws DaoException;
}
