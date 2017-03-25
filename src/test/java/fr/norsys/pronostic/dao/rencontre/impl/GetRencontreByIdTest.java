package fr.norsys.pronostic.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;

public class GetRencontreByIdTest extends ARencontreTest {
	@Test
	public void shouldReturnRencontreWhenGetById() throws DaoException {
		Rencontre rencontre = this.rencontreDao.getById(8L).get();
		assertThat(rencontre).isNotNull();
	}

	@Test(expected = DaoException.class)
	public void shouldThrowTechniqueException() throws DaoException {
		this.rencontreDao.getById(500L);
	}
}
