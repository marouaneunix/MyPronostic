package fr.norsys.pronostic.dao.salarie.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;

public class GetSalarieByIdTest extends ASalarieTest {

	@Test
	public void shoudlReturnSalarieWhenGetById() throws DaoException {
		Optional<Salarie> salarie = this.salarieDao.getById(1L);
		assertThat(salarie.isPresent()).isTrue();
	}

	@Test(expected = DaoException.class)
	public void shoudlThrowTechniqueException() throws DaoException {
		this.salarieDao.getById(5000L);
	}
}
