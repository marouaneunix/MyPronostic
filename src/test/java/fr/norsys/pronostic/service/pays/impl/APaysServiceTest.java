package fr.norsys.pronostic.service.pays.impl;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.service.pays.PaysService;

public abstract class APaysServiceTest {

	protected PaysService paysService;

	@Mock
	protected PaysDao mockPaysDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.paysService = new PaysServiceImpl(this.mockPaysDAO);
	}
}