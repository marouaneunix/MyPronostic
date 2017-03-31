package fr.norsys.pronostic.service.salarie.imp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetSalarieByUsernameTest extends ASalarieServiceTest {

	@Test
	public void shoudReturnSalarieWhenGetPaysByUsername() throws DaoException, DataServiceException {

		Salarie s = new Salarie();
		s.setUsername("saoud");

		doReturn(Optional.ofNullable(s)).when(this.mockSalarieDao).getSalarieByUsername("saoud");

		Salarie salarie = this.salarieService.getSalariebyUsername("saoud").get();

		assertNotNull(salarie);
		assertEquals("saoud", salarie.getUsername());
		verify(this.mockSalarieDao, times(1)).getSalarieByUsername("saoud");

	}

	@Test
	public void shoudThrowDataServiceException() throws DaoException, DataServiceException {

		doReturn(Optional.ofNullable(null)).when(this.mockSalarieDao).getSalarieByUsername("anonymous");
		assertThat(this.salarieService.getSalariebyUsername("anonymous").isPresent()).isFalse();




		verify(this.mockSalarieDao, times(1)).getSalarieByUsername("anonymous");

	}

}
