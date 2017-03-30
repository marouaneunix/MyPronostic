package fr.norsys.pronostic.dao.competition.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;

public class GetCompetitonByIdTest extends ACompetitonDaoTest {

	@Test
	public void shouldGetCompetitionTest() throws DaoException {
		Optional<Competition> competition = this.competitionDao.getById(1L);
		assertThat(competition).isNotNull();
		assertThat(competition.get().getId()).isEqualTo(1L);
	}

	@Test
	public void shouldThrowDaoExceptionWhenGetById() throws DaoException {
		assertThat(this.competitionDao.getById(500L).isPresent()).isFalse();
	}

}
