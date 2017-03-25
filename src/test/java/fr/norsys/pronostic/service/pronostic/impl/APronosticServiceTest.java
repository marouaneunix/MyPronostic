package fr.norsys.pronostic.service.pronostic.impl;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.pronostic.dao.pronostic.PronosticDao;
import fr.norsys.pronostic.service.pronostic.PronosticService;

public abstract class APronosticServiceTest {

	protected PronosticService pronosticService;
	@Mock
	protected PronosticDao mockPronosticDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.pronosticService = new PronosticServiceImpl(this.mockPronosticDAO);
	}
}