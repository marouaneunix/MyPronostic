package fr.norsys.pronostic.dao.salarie.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;
import org.springframework.dao.EmptyResultDataAccessException;

public class GetSalarieByUserNameTest extends ASalarieTest {

	@Test
	public void shoudlReturnSalarieWhenGetByName() throws DaoException {
		Optional<Salarie> salarie = this.salarieDao.getSalarieByUsername("marouane");
		assertThat(salarie.get().getUsername()).isEqualTo("marouane");
		assertThat(salarie.get().getRole().getNom()).isEqualTo("ROLE_USER");

	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void shoudlThrowTechniqueException() throws DaoException {
		this.salarieDao.getSalarieByUsername("badUserName");
	}
}
