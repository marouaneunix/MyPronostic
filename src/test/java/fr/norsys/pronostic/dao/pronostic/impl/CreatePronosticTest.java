package fr.norsys.pronostic.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.domain.Role;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

public class CreatePronosticTest extends APronosticTest {


	@Test
	public void shouldReturn1WhenInsertSucces() throws DaoException {

		Rencontre rencontre = rencontreDao.getById(1L).get();

		Salarie salarie = salarieDao.getById(1L).get();
		Pronostic pronostic = new Pronostic();
		pronostic.setBut1(20);
		pronostic.setBut2(20);
		pronostic.setNote(0);
		pronostic.setSalarie(salarie);
		pronostic.setRencontre(rencontre);
		pronosticDao.createPronostic(pronostic);
		assertThat(rencontreDao.getById(1L).get().getPronostics().stream().anyMatch(p -> p.getBut1() == 20 && p.getBut2() == 20)).isTrue();
	}

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void shouldThrowDaoExceptionWhenPronosticEqtNull() throws DaoException {
		this.pronosticDao.createPronostic(null);

	}
}
