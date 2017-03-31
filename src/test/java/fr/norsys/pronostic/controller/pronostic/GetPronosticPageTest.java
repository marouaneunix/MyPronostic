package fr.norsys.pronostic.controller.pronostic;


import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.domain.Salarie;
import fr.norsys.pronostic.utils.AuthenticationUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class GetPronosticPageTest extends AMesPronosticsTest {

    @Test
    public void shouldReturnViewPronostic() throws Exception {
        List<Rencontre> rencontres = Arrays.asList(new Rencontre(), new Rencontre());
        Poule poule = new Poule();
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.pronosticController).build();
        Salarie salarie = new Salarie(1L);
        PowerMockito.mockStatic(AuthenticationUtil.class);
        when(AuthenticationUtil.getAuthenticatedUser()).thenReturn(this.authentication);
        when(this.authentication.getPrincipal()).thenReturn(salarie);
        when(this.req.getSession()).thenReturn(this.httpSession);
        when(this.rencontreService.getRencontresNonPronostiquerByIdPoule(salarie.getId(), 1L)).thenReturn(rencontres);
        when(this.pouleService.getPoulebyId(1L)).thenReturn(Optional.ofNullable(poule));

        this.mockMvc.perform(get("/pronostiquez/{idPoule}", 1L)).andExpect(status().isOk())
                .andExpect(view().name("salarie/pronostic"));
    }

}
