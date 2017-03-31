package fr.norsys.pronostic.dao.pronostic;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.domain.Pronostic;

@Repository
public interface PronosticDao  {

	List<Pronostic> getAllPronosticsBySalarieId(Long id);
	void createPronostic(Pronostic pronostic);
	List getAll();

}
