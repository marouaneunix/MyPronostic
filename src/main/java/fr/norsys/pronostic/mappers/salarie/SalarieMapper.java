package fr.norsys.pronostic.mappers.salarie;

import fr.norsys.pronostic.domain.Role;
import fr.norsys.pronostic.domain.Salarie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/28/17.
 */
public class SalarieMapper implements RowMapper<Salarie> {
    @Override
    public Salarie mapRow(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role(resultSet.getLong("ID_ROLE"),resultSet.getString("ROLE_NOM"));

        return new Salarie(resultSet.getLong("ID_SALARIE"),
                    resultSet.getString("NOM"),
                    resultSet.getString("PRENOM"),
                resultSet.getString("USERNAME"),
                resultSet.getString("PASSWORD"),role,null);
    }
}
