package fr.norsys.pronostic.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;

public class GetRencontreByPouleIdTest extends ARencontreTest {

	@Test
	public void shouldReturnRencontresByPouleId() throws DaoException {
		List<Rencontre> rencontres = this.rencontreDao.getAllByIdPoule(1L);
		assertThat(rencontres.size()).isGreaterThan(1);

	}
}
