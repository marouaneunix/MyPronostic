package fr.norsys.pronostic.service.salarie.imp;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetailsService;

import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.service.salarie.SalarieService;
import fr.norsys.pronostic.service.salarie.impl.AuthenticationServiceImpl;
import fr.norsys.pronostic.service.salarie.impl.SalarieServiceImpl;

public abstract class ASalarieServiceTest {

	protected SalarieService salarieService;
	protected UserDetailsService userdetailService;
	@Mock
	protected SalarieDao mockSalarieDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.salarieService = new SalarieServiceImpl(this.mockSalarieDao);
		this.userdetailService = new AuthenticationServiceImpl(this.mockSalarieDao);
	}
}