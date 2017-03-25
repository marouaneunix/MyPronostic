package fr.norsys.pronostic.service.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetRencontresByIdPouleTest extends ARencontreServiceTest {

	@Test
	public void shoudReturnRencontreByPouleId() throws DataServiceException, DaoException {

		List<Rencontre> rencontres = Arrays.asList(new Rencontre(), new Rencontre(), new Rencontre());

		doReturn(rencontres).when(this.mockRencontreDAO).getAllByIdPoule(1L);

		assertThat(this.rencontreService.getRencontresByIdPoule(1L).size()).isEqualTo(rencontres.size());
		verify(this.mockRencontreDAO, times(1)).getAllByIdPoule(1L);
	}

}
