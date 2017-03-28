package fr.norsys.pronostic.mappers.role;

import fr.norsys.pronostic.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/28/17.
 */
public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Role(resultSet.getLong("ID_ROLE"),resultSet.getString("NOM"));
    }
}
