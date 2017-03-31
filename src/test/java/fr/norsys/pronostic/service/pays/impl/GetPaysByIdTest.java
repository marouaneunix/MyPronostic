package fr.norsys.pronostic.service.pays.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;
import org.springframework.dao.EmptyResultDataAccessException;

public class GetPaysByIdTest extends APaysServiceTest {

	@Test
	public void shoudReturnPaysWhenGetPaysById() throws DataServiceException, DaoException {

		doReturn(Optional.ofNullable(new Pays(4L, "ma", "lo"))).when(this.mockPaysDAO).getById(4L);
		this.paysService.getPaysbyId(4L).get();
		verify(this.mockPaysDAO, times(1)).getById(4L);
	}

	@Test
	public void shouldThrowTechnocalException() throws DataServiceException, DaoException {

		doReturn(Optional.ofNullable(null)).when(this.mockPaysDAO).getById(555L);

		assertThat(this.paysService.getPaysbyId(555L).isPresent()).isFalse();
		verify(this.mockPaysDAO, times(1)).getById(555L);
	}

}
