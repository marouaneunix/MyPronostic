package fr.norsys.pronostic.dao.competition;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.IDAO;
import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;

@Repository
public interface CompetitionDao extends IDAO<Competition> {

	List<Competition> getAll() throws DaoException;

}