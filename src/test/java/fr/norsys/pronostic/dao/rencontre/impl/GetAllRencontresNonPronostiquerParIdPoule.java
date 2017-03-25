package fr.norsys.pronostic.dao.rencontre.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;

public class GetAllRencontresNonPronostiquerParIdPoule extends ARencontreTest {

	@Ignore
	@Test
	public void shouldReturnRencontreWhenGetRencontreByIDPouleNonPronostiquer() throws DaoException {
		// TODO: MySQL Query not working h2 DB !! test Fail
		List<Rencontre> rencontres = this.rencontreDao.getAllRencontresNonPronostiquerParPouleID(1L, 2L);
		assertThat(rencontres.stream().count()).isEqualTo(1);

	}
}
