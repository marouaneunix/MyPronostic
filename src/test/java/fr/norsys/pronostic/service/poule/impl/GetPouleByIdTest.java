package fr.norsys.pronostic.service.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetPouleByIdTest extends APouleServiceTest {

	@Test
	public void shoudReturnPoule() throws DaoException, DataServiceException {

		Poule poule = new Poule(1L, "p1", false, null);
		doReturn(Optional.ofNullable(poule)).when(this.mockPouleDAO).getById(1L);

		assertThat(this.pouleService.getPoulebyId(1L).get().getId()).isEqualTo(1L);
		verify(this.mockPouleDAO, times(1)).getById(1L);

	}

	@Test(expected = DataServiceException.class)
	public void shoudThrowDataServiceException() throws DaoException, DataServiceException {

		doThrow(DataServiceException.class).when(this.mockPouleDAO).getById(500L);

		this.pouleService.getPoulebyId(500L);
		verify(this.mockPouleDAO, times(1)).getById(1L);

	}

}
