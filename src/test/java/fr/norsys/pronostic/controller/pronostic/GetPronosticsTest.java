package fr.norsys.pronostic.controller.pronostic;


import fr.norsys.pronostic.domain.*;
import fr.norsys.pronostic.utils.AuthenticationUtil;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class GetPronosticsTest extends AMesPronosticsTest {

    @Test
    public void shouldReturnViewMesPronostics() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mesPronosticsController).build();
        Salarie salarie = new Salarie(1L);

        PowerMockito.mockStatic(AuthenticationUtil.class);

        when(AuthenticationUtil.getAuthenticatedUser()).thenReturn(this.authentication);
        when(this.authentication.getPrincipal()).thenReturn(salarie);

        Competition competition = new Competition();
        Poule poule = new Poule();
        Poule poule2 = new Poule();
        poule.setCompetition(competition);
        poule2.setCompetition(competition);
        Rencontre rencontre = new Rencontre();
        Rencontre rencontre2 = new Rencontre();
        Pronostic pronostic = new Pronostic();
        pronostic.setRencontre(rencontre2);
        pronostic.getRencontre().setPoule(poule2);
        Pronostic pronostic2 = new Pronostic();
        pronostic2.setRencontre(rencontre);
        pronostic2.getRencontre().setPoule(poule);

        List<Pronostic> pronostics = Arrays.asList(pronostic, pronostic2);
        doReturn(pronostics).when(this.pronosticService).getAllBySalarieId(salarie.getId());
        this.mockMvc.perform(get("/mes_pronostics")).andExpect(view().name("salarie/mes_pronostics"));
        verify(this.pronosticService, times(1)).getAllBySalarieId(1L);
        verify(this.authentication, times(1)).getPrincipal();

    }

}
