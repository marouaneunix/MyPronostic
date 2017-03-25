package fr.norsys.pronostic.mappers.pays;

import fr.norsys.pronostic.domain.Pays;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/25/17.
 */
public class PaysMapper implements RowMapper<Pays> {

    @Override
    public Pays mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Pays(resultSet.getLong("ID_PAYS"),resultSet.getString("NOM"),resultSet.getString("LOGO"));
    }
}
