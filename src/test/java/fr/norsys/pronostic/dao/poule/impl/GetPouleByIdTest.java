package fr.norsys.pronostic.dao.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;

public class GetPouleByIdTest extends APouleTest {

	@Test
	public void shouldReturnPouleById() throws DaoException {
		Optional<Poule> poule = this.pouleDao.getById(1L);
		assertThat(poule.isPresent()).isNotNull();
		assertThat(poule.get().getId()).isEqualByComparingTo(1L);
		assertThat(poule.get().getCompetition().getId()).isEqualTo(1L);
	}

	@Test(expected = DaoException.class)
	public void shouldThrowDaoException() throws DaoException {
		this.pouleDao.getById(500L);
	}
}
