package fr.norsys.pronostic.service.poule.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.exception.DataServiceException;

public class GetAllPouleByIdCompetitonTest extends APouleServiceTest {

	@Test
	public void shoudReturnPouleWhenCompititonIs1() throws DaoException, DataServiceException {

		List<Poule> poules = Arrays.asList(new Poule(), new Poule(), new Poule());
		doReturn(poules).when(this.mockPouleDAO).getAllPoulesByCompetitionId(1L);

		assertThat(this.pouleService.getAllPouleByIdCompetiton(1L).size()).isEqualTo(poules.size());
		verify(this.mockPouleDAO, times(1)).getAllPoulesByCompetitionId(1L);

	}

}
