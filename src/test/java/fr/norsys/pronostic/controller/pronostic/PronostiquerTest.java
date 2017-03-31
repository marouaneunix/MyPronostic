package fr.norsys.pronostic.controller.pronostic;


import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.utils.AuthenticationUtil;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PronostiquerTest extends AMesPronosticsTest {

    @Test
    public void shouldCreatePronosticAndRedirectToMesPronostics() throws Exception {
        Rencontre rencontre = new Rencontre();
        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("idPoule", 1);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.pronosticController).build();
        Salarie salarie = new Salarie(1L);
        PowerMockito.mockStatic(AuthenticationUtil.class);
        when(AuthenticationUtil.getAuthenticatedUser()).thenReturn(this.authentication);
        when(this.authentication.getPrincipal()).thenReturn(salarie);

        when(this.rencontreService.getRencontrebyId(1L)).thenReturn(Optional.ofNullable(rencontre));
        this.mockMvc
                .perform(post("/pronostiquez").param("rencontre", "1").param("but_1", "2").param("but_2", "2")
                        .session(mockHttpSession))
                .andExpect(status().is(302)).andExpect(redirectedUrl("/pronostiquez/" + 1));
        verify(this.authentication, times(1)).getPrincipal();
        verify(this.rencontreService, times(1)).getRencontrebyId(1L);
    }

}
