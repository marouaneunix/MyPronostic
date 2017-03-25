package fr.norsys.pronostic.dao.pays.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;

public class GetPaysByPouleTest extends APaysDaoTest {

	@Test
	public void shouldReturnPays() throws DaoException {

		List<Pays> payss = this.paysDao.getPaysByPoule(1L);
		assertThat(payss).isNotNull();
		assertThat(payss).isNotEmpty();
	}
}
