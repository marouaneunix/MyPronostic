package fr.norsys.pronostic.dao.pronostic.impl;

import fr.norsys.pronostic.domain.Pronostic;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mar1 on 3/30/17.
 */
public class GetAllPronosticsTest extends APronosticTest {

    @Test
    public void shouldGetAllPronostics(){
        List<Pronostic> pronostics = this.pronosticDao.getAll();
        assertThat(pronostics).isNotEmpty();
    }
}
