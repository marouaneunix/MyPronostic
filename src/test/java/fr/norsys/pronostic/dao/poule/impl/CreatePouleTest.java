package fr.norsys.pronostic.dao.poule.impl;

import fr.norsys.pronostic.domain.Poule;
import org.junit.Test;

/**
 * Created by mar1 on 4/3/17.
 */
public class CreatePouleTest extends  APouleTest {

    @Test
    public void shouldCreatePoule(){
        Poule poule = new Poule();
        poule.setCompetition(competitionDao.getById(1L).get());
        poule.setGroupe(false);
        poule.setNom("Demi Finale");
        this.pouleDao.createPoule(poule);


    }
}
