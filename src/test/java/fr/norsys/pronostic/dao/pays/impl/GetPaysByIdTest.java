package fr.norsys.pronostic.dao.pays.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;

public class GetPaysByIdTest extends APaysDaoTest {

	@Test
	public void shoulReturnPay() throws DaoException {
		Optional<Pays> togo = this.paysDao.getById(2L);
		assertThat(togo.get().getId()).isEqualTo(2L);
	}

	@Test
	public void shouldThrowTechnocalException() throws DaoException {
		Optional<Pays> togo = this.paysDao.getById(5000L);
		assertThat(togo.isPresent()).isFalse();
	}
}
