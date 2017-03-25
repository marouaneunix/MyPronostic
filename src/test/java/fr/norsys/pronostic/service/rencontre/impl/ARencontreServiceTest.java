package fr.norsys.pronostic.service.rencontre.impl;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.pronostic.dao.rencontre.RencontreDao;
import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.service.rencontre.RencontreService;

public abstract class ARencontreServiceTest {

	protected RencontreService rencontreService;
	@Mock
	protected SalarieDao mockSalarieDao;
	@Mock
	protected RencontreDao mockRencontreDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.rencontreService = new RencontreServiceImpl(this.mockRencontreDAO);
	}
}