package fr.norsys.pronostic.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.competition.CompetitionService;
import fr.norsys.pronostic.service.pays.PaysService;
import fr.norsys.pronostic.service.poule.PouleService;

@Controller
@RequestMapping("/")
public class CompetitionController {

	@Autowired
	private PouleService pouleService;
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private PaysService paysService;

	private static final String POULE_VIEW = "salarie/poule";

	@GetMapping({ "competition", "" })
	public String getCompetitions(Model model) throws DataServiceException {
		List<Competition> competitions = new ArrayList<>();
		competitions = this.competitionService.getAllCompetitions();
		model.addAttribute("competitions", competitions);
		return "salarie/competition";
	}

	@GetMapping("competition/{id}")
	public String getPoules(Model model, @PathVariable("id") Long id) {
		List<Poule> list_poule = new ArrayList<>();
		Competition competition = null;
		Map<Poule, List<Pays>> map = new HashMap<>();
		try {
			competition = this.competitionService.getCompetitionById(id).get();
			list_poule = this.pouleService.getAllPouleByIdCompetiton(id);
			list_poule.stream().forEach(l -> {
				try {
					map.put(l, this.paysService.getPaysByIdPoule(l.getId()));
				} catch (DataServiceException e) {
					model.addAttribute("erreur", "erreur dans la recuperation des pays par l'id du poule");
				}

			});
		} catch (DataServiceException e) {
			model.addAttribute("erreur", "erreur dans la recuperation des pays par l'id du poule");
		}
		model.addAttribute("map_poule_pays", map);
		model.addAttribute("poules", list_poule);
		model.addAttribute("competition", competition);
		return POULE_VIEW;
	}

}
