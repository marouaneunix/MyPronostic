package fr.norsys.pronostic.dao.pays;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.domain.Pays;

@Repository
public interface PaysDao {

	List<Pays> getPaysByPoule(Long id);
	Optional<Pays> getById(Long od);
}
