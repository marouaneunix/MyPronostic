package fr.norsys.pronostic.dao.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;

public class GetAllPoulesByIdCompetitionTest extends APouleTest {

	@Test
	public void shouldReturnCompetitionPoules() throws DaoException {
		List<Poule> poules = this.pouleDao.getAllPoulesByCompetitionId(1L);
		assertThat(poules.stream().count()).isEqualTo(4);
	}

	@Test()
	public void shouldBeEmpty() throws DaoException{
		List<Poule> poules = this.pouleDao.getAllPoulesByCompetitionId(500L);
		assertThat(poules.isEmpty()).isTrue();
	}

}
