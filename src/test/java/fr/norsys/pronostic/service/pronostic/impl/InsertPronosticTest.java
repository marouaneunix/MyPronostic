package fr.norsys.pronostic.service.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class InsertPronosticTest extends APronosticServiceTest {
	@Test
	public void shoulReturn1WhenInsertSucces() throws DaoException, DataServiceException {

		Pronostic p = new Pronostic();
		doReturn(1).when(this.mockPronosticDAO).create(p);

		int rs = this.pronosticService.create(p);
		assertThat(rs).isEqualTo(1);
		verify(this.mockPronosticDAO, times(1)).create(p);
	}

	@Test(expected = DataServiceException.class)
	public void shoulThrowException() throws DaoException, DataServiceException {
		Pronostic pronostic = null;
		doThrow(DaoException.class).when(this.mockPronosticDAO).create(pronostic);

		this.pronosticService.create(pronostic);
	}
}
