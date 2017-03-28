package fr.norsys.pronostic.dao.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;

public class GetAllPronosticsBySalarieIdTest extends APronosticTest {
	@Test
	public void shouldReturnAllPronosticsBySalarieId() throws DaoException {
		List<Pronostic> pronostics = this.pronosticDao.getAllPronosticsBySalarieId(3L);
		assertThat(pronostics.stream().count()).isGreaterThan(2);
	}

	@Test
	public void shoudlBeEmpty(){
		List<Pronostic> pronostics = this.pronosticDao.getAllPronosticsBySalarieId(500L);
		assertThat(pronostics).isEmpty();
	}
}
