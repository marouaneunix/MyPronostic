package fr.norsys.pronostic.service.salarie.imp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetSalarieByIdTest extends ASalarieServiceTest {

	@Test
	public void shoudReturnSalarieWhenGetPaysById() throws DaoException, DataServiceException {

		doReturn(Optional.ofNullable(new Salarie(3L))).when(this.mockSalarieDao).getById(3L);

		Salarie salarie = this.salarieService.getSalariebyId(3L).get();

		assertThat(salarie.getId()).isEqualTo(3L);
		verify(this.mockSalarieDao, times(1)).getById(3L);
	}

	@Test
	public void shoudThrowDataServiceException() throws DaoException, DataServiceException {

		doReturn(Optional.ofNullable(null)).when(this.mockSalarieDao).getById(500L);
		assertThat(this.salarieService.getSalariebyId(500L).isPresent()).isFalse();


		verify(this.mockSalarieDao, times(1)).getById(500L);
	}

}
