package fr.norsys.pronostic.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;

public class GetAllRencontresTest extends ARencontreTest {

	@Test
	public void shoudlReturnAllRencontres() throws DaoException {
		List<Rencontre> rencontres = this.rencontreDao.getAll();
		assertThat(rencontres.stream().count()).isGreaterThan(1);
	}

}
