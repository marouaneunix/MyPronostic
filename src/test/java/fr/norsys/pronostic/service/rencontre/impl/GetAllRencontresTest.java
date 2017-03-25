package fr.norsys.pronostic.service.rencontre.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetAllRencontresTest extends ARencontreServiceTest {

	@Test
	public void shoudReturnAllRencontres() throws DaoException, DataServiceException {

		List<Rencontre> rencontres = Arrays.asList(new Rencontre(), new Rencontre(), new Rencontre());

		doReturn(rencontres).when(this.mockRencontreDAO).getAll();

		List<Rencontre> rencontresFromSv = this.rencontreService.getAll();

		assertNotNull(rencontres);
		assertEquals(rencontres.size(), rencontresFromSv.size());
		verify(this.mockRencontreDAO, times(1)).getAll();
	}

}
