package fr.norsys.pronostic.service.salarie.imp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.norsys.pronostic.domain.CustomUserDetails;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.exception.DaoException;

public class LoadUserByUsernameTest extends ASalarieServiceTest {

	@Test
	public void shouldReturnUserDetails() throws DaoException {
		Salarie salarie = new Salarie(1L, "elmerrouni", "maroaune", "mar1", "password", null);
		doReturn(Optional.ofNullable(salarie)).when(this.mockSalarieDao).getSalarieByUsername("mar1");

		CustomUserDetails customUserDetails = new CustomUserDetails(salarie);

		assertThat(this.userdetailService.loadUserByUsername("mar1").getUsername())
				.isEqualTo(customUserDetails.getUsername());
		verify(this.mockSalarieDao, times(1)).getSalarieByUsername("mar1");

	}

	@Test(expected = UsernameNotFoundException.class)
	public void shouldThrowUserNotFoundException() throws DaoException {

		doThrow(UsernameNotFoundException.class).when(this.mockSalarieDao).getSalarieByUsername("anonymous");

		this.userdetailService.loadUserByUsername("anonymous");

		verify(this.mockSalarieDao, times(1)).getSalarieByUsername("anonymous");

	}
}
