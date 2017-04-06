package fr.norsys.pronostic.dao.poule.impl;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.domain.Poule;
import org.junit.Test;

import java.util.List;

/**
 * Created by mar1 on 4/3/17.
 */
public class CreatePouleTest extends  APouleTest {

    @Test
    public void shouldCreatePoule(){
        Competition competition = competitionDao.getById(1L).get();
        Pays pays = paysDao.getById(1L).get();
        Pays pays1 = paysDao.getById(2L).get();
        Poule poule = new Poule();
        poule.setCompetition(competition);
        poule.setGroupe(false);
        poule.setNom("Demi Finale");
        poule.getPayss().add(pays);
        poule.getPayss().add(pays1);
        this.pouleDao.createPoule(poule);

        Poule poule1 = pouleDao.getById(5L).orElse(new Poule());
        System.out.println(poule1.getNom());

    }

    @Test
    public void shoudCC(){
        List<Poule> poules = this.pouleDao.getAllPoulesByCompetitionId(1L);
        poules.stream().map(Poule::getNom).forEach(System.out::println);
    }
}
