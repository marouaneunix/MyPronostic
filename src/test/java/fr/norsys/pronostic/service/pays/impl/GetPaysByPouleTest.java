package fr.norsys.pronostic.service.pays.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetPaysByPouleTest extends APaysServiceTest {

	@Test
	public void shoudReturnPaysWhenGetPaysById() throws DataServiceException, DaoException {
		List<Pays> pays = Arrays.asList(new Pays(), new Pays(), new Pays(), new Pays());
		doReturn(pays).when(this.mockPaysDAO).getPaysByPoule(1L);
		assertThat(this.paysService.getPaysByIdPoule(1L).size()).isEqualTo(pays.size());
		verify(this.mockPaysDAO, times(1)).getPaysByPoule(1L);
	}

}
