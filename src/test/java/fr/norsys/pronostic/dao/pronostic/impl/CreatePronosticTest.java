package fr.norsys.pronostic.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.domain.Role;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;

public class CreatePronosticTest extends APronosticTest {

	@Test
	public void shouldReturn1WhenInsertSucces() throws DaoException {

		Competition competition = new Competition(1L, "CAN ", LocalDate.now());
		Poule poule = new Poule(1L, "A", true, competition);
		Pays pays1 = new Pays(1L, "maroc", "hhhh");
		Pays pays2 = new Pays(2L, "togo", "mmmm");
		Rencontre rencontre = new Rencontre(1L, pays1, pays2, 1, 2, poule, LocalDateTime.now());
		Role role = new Role(1L, "ROLE_USER");
		Salarie salarie = new Salarie(1L, "badouch", "mohamed", "badouch", "password", role);
		int rs = this.pronosticDao.create(new Pronostic(1L, 2, 1, 0, rencontre, salarie));
		assertThat(rs).isEqualTo(1);
	}

	@Test(expected = DaoException.class)
	public void shouldThrowDaoExceptionWhenPronosticEqtNull() throws DaoException {
		this.pronosticDao.create(null);

	}
}
