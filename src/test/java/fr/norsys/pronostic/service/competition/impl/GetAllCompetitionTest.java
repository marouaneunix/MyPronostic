package fr.norsys.pronostic.service.competition.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetAllCompetitionTest extends ACompetitonServiceTest {

	@Test
	public void shoudReturnAllCompetition() throws DaoException, DataServiceException {
		List<Competition> competitions = Arrays.asList(new Competition(), new Competition());
		doReturn(competitions).when(this.mockCompetionDAO).getAll();
		assertThat(this.competitionService.getAllCompetitions().stream().count())
				.isEqualTo(competitions.stream().count());
		verify(this.mockCompetionDAO, times(1)).getAll();
	}

}
