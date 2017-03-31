package fr.norsys.pronostic.web.controller.pronostic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.poule.PouleService;
import fr.norsys.pronostic.service.pronostic.PronosticService;
import fr.norsys.pronostic.service.rencontre.RencontreService;
import fr.norsys.pronostic.utils.AuthenticationUtil;

@Controller
public class PronosticController {
	private static final String CHAMP_RENCONTRE = "rencontre";
	private static final String CHAMP_BUT_1 = "but_1";
	private static final String CHAMP_BUT_2 = "but_2";
	private static final String PRONOSTIC_VIEW = "salarie/pronostic";
	private static final String REDIRECT_URL = "redirect:/pronostiquez/";

	@Autowired
	private PronosticService pronosticService;
	@Autowired
	private RencontreService rencontreService;
	@Autowired
	private PouleService pouleService;

	@GetMapping("/pronostiquez/{idPoule}")
	public String getPronosticPage(Model model, @PathVariable("idPoule") Long idPoule, HttpServletRequest req)
			throws DataServiceException {

		List<Rencontre> rencontres = new ArrayList<>();

		req.getSession().setAttribute("idPoule", idPoule);
		Salarie salarie = (Salarie) AuthenticationUtil.getAuthenticatedUser().getPrincipal();

		rencontres = this.rencontreService.getRencontresNonPronostiquerByIdPoule(salarie.getId(), idPoule);

		Poule poule = this.pouleService.getPoulebyId(idPoule).get();

		model.addAttribute("poule", poule);
		model.addAttribute("rencontres", rencontres);

		return PRONOSTIC_VIEW;
	}

	@PostMapping("/pronostiquez")
	public String pronostiquer(Model model, HttpServletRequest req) throws DataServiceException {

		long rencontreId = Long.valueOf(req.getParameter(CHAMP_RENCONTRE));
		int but1 = Integer.valueOf(req.getParameter(CHAMP_BUT_1));
		int but2 = Integer.valueOf(req.getParameter(CHAMP_BUT_2));
		Salarie salarie = (Salarie) AuthenticationUtil.getAuthenticatedUser().getPrincipal();

		Rencontre rencontre = this.rencontreService.getRencontrebyId(rencontreId).get();
		Pronostic pronostic = new Pronostic(1L, but1, but2, 0, rencontre, salarie);
		this.pronosticService.create(pronostic);

		return REDIRECT_URL + req.getSession().getAttribute("idPoule");
	}

}
