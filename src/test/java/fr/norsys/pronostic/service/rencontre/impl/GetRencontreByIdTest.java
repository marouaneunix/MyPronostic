package fr.norsys.pronostic.service.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetRencontreByIdTest extends ARencontreServiceTest {

	@Test(expected = DataServiceException.class)
	public void shoudlThrowTechniqueException() throws DaoException, DataServiceException {

		doThrow(DataServiceException.class).when(this.mockRencontreDAO).getById(555L);

		this.rencontreService.getRencontrebyId(555L).get();

		verify(this.mockRencontreDAO, times(1)).getById(555L);

	}

	@Test
	public void shoudReturnRencontreById() throws DataServiceException, DaoException {

		doReturn(Optional.ofNullable(new Rencontre(4L))).when(this.mockRencontreDAO).getById(4L);

		Rencontre rencontre = this.rencontreService.getRencontrebyId(4L).get();
		assertThat(rencontre.getId()).isEqualTo(4L);
		verify(this.mockRencontreDAO, times(1)).getById(4L);
	}

}
