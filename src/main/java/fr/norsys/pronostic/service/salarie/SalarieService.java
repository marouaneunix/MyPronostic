package fr.norsys.pronostic.service.salarie;


import fr.norsys.pronostic.domain.Salarie;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface SalarieService {

	Optional<Salarie> getSalariebyId(Long id) ;

	Optional<Salarie> getSalariebyUsername(String name);

}
