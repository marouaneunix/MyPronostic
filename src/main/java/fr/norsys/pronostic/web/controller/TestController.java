package fr.norsys.pronostic.web.controller;

import fr.norsys.pronostic.dao.role.RoleDao;
import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DataServiceException;
import fr.norsys.pronostic.service.salarie.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mar1 on 3/28/17.
 */
@Controller
@RequestMapping("/XXX")
public class TestController {


    private SalarieService salarieService;

    @Autowired
    public void setSalarieService(SalarieService salarieService){
        this.salarieService = salarieService;
    }

    @GetMapping
    public String getXXX() throws DataServiceException {
        System.out.println(salarieService.getSalariebyId(1L).getNom());

        return "XXXX";
    }
}
