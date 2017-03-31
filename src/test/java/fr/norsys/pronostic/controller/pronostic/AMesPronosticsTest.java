package fr.norsys.pronostic.controller.pronostic;


import fr.norsys.pronostic.service.poule.PouleService;
import fr.norsys.pronostic.service.pronostic.PronosticService;
import fr.norsys.pronostic.service.rencontre.RencontreService;
import fr.norsys.pronostic.utils.AuthenticationUtil;
import fr.norsys.pronostic.web.controller.pronostic.MesPronosticsController;
import fr.norsys.pronostic.web.controller.pronostic.PronosticController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AuthenticationUtil.class })
public abstract class AMesPronosticsTest {

    @InjectMocks
    protected MesPronosticsController mesPronosticsController;

    @InjectMocks
    protected PronosticController pronosticController;

    @Mock
    protected PronosticService pronosticService;

    @Mock
    protected RencontreService rencontreService;

    @Mock
    protected PouleService pouleService;

    @Mock
    protected Authentication authentication;

    @Mock
    protected HttpSession httpSession;

    @Mock
    protected HttpServletRequest req;

    protected MockMvc mockMvc;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);

    }
}