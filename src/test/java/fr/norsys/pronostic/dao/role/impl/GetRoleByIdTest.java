package fr.norsys.pronostic.dao.role.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import fr.norsys.pronostic.domain.Role;
import fr.norsys.pronostic.exception.DaoException;

public class GetRoleByIdTest extends ARoleDaoTest {

	@Test
	public void shouldReturnRole() throws DaoException {
		Optional<Role> role = this.roleDao.getById(1L);
		assertThat(role.isPresent()).isTrue();
		assertThat(role.get().getNom()).isEqualTo("ROLE_ADMIN");
	}

	@Test
	public void shouldThrowDaoException()  {
		Optional<Role> role = this.roleDao.getById(500L);
		assertThat(role.isPresent()).isFalse();
	}
}
