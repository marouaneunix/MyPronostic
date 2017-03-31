package fr.norsys.pronostic.service.pronostic.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

public class InsertPronosticTest extends APronosticServiceTest {
	@Test
	public void shoulReturn1WhenInsertSucces() throws DaoException, DataServiceException {

		Pronostic p = new Pronostic();
		doNothing().when(this.mockPronosticDAO).createPronostic(p);
		try{
			this.pronosticService.create(p);

		}catch (Exception e){
			throw e;
		}
		assertThat(true).isTrue();
		verify(this.mockPronosticDAO, times(1)).createPronostic(p);
	}

	@Test(expected = DataServiceException.class)
	public void shoulThrowException() throws DaoException, DataServiceException {
		Pronostic pronostic = null;
		doThrow(InvalidDataAccessApiUsageException.class).when(this.mockPronosticDAO).createPronostic(pronostic);

		this.pronosticService.create(pronostic);
	}
}
