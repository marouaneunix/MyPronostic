package fr.norsys.pronostic.web.controller.pronostic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.pronostic.PronosticService;
import fr.norsys.pronostic.utils.AuthenticationUtil;

@Controller
public class MesPronosticsController {


	private static final String VUE = "salarie/mes_pronostics";
	@Autowired
	private PronosticService pronosticService;

	@GetMapping("/mes_pronostics")
	public String getPronostics(Model model) throws DataServiceException {
		Salarie salarie = (Salarie) AuthenticationUtil.getAuthenticatedUser().getPrincipal();
		List<Pronostic> pronostics = new ArrayList<>();
		Set<Competition> competitions = new HashSet<>();
		Set<Poule> poules = new HashSet<>();
		pronostics = this.pronosticService.getAllBySalarieId(salarie.getId());

		for (Pronostic pronostic : pronostics) {

			competitions.add(pronostic.getRencontre().getPoule().getCompetition());
			poules.add(pronostic.getRencontre().getPoule());
		}

		model.addAttribute("pronostics", pronostics);
		model.addAttribute("competitions", competitions);
		model.addAttribute("poules", poules);
		return VUE;
	}

}
