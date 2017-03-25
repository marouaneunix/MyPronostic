package fr.norsys.pronostic.dao.competition.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;

public class GetAllCompetionsTest extends ACompetitonDaoTest {

	@Test
	public void shouldReturnAllCompetitions() throws DaoException {
		List<Competition> competitions = this.competitionDao.getAll();
		assertThat(competitions).isNotNull();
		assertThat(competitions).isNotEmpty();
	}
}
