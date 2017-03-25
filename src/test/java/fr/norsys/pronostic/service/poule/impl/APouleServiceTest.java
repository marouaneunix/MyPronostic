package fr.norsys.pronostic.service.poule.impl;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.service.poule.PouleService;

public abstract class APouleServiceTest {

	protected PouleService pouleService;
	@Mock
	protected PouleDao mockPouleDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.pouleService = new PouleServiceImpl(this.mockPouleDAO);
	}
}