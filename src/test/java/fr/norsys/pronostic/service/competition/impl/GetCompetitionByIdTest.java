package fr.norsys.pronostic.service.competition.impl;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

/**
 * Created by SAOUD on 3/20/17.
 */
public class GetCompetitionByIdTest extends ACompetitonServiceTest {

	@Test
	public void shoudReturnCompetitionWhenGetCompetitionById() throws DaoException, DataServiceException {
		doReturn(Optional.ofNullable(new Competition(1L, "com1", LocalDate.now()))).when(this.mockCompetionDAO)
				.getById(1L);
		this.competitionService.getCompetitionById(1L).get();
		verify(this.mockCompetionDAO, times(1)).getById(1L);
	}

	@Test(expected = DataServiceException.class)
	public void shoudThrowDataServiceException() throws DaoException, DataServiceException {
		doThrow(DaoException.class).when(this.mockCompetionDAO).getById(500L);
		this.competitionService.getCompetitionById(500L);

	}

}
