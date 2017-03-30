package fr.norsys.pronostic.dao.salarie.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;

public class GetSalarieByIdTest extends ASalarieTest {

	@Test
	public void shoudlReturnSalarieWhenGetById() throws DaoException {
		Salarie salarie = this.salarieDao.getById(1L).get();
		assertThat(salarie.getId()).isEqualTo(1L);
	}

	@Test
	public void shoudlBeNotPresent() throws DaoException {
		assertThat(this.salarieDao.getById(5000L).isPresent()).isFalse();
	}
}
