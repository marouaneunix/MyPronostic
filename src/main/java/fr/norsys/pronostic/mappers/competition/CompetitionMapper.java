package fr.norsys.pronostic.mappers.competition;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.utils.DateFormat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/25/17.
 */
public  final class CompetitionMapper implements RowMapper<Competition>{

    @Override
    public Competition mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Competition(resultSet.getLong("ID_COMPETITION"),resultSet.getString("NOM"), DateFormat.formatToLocalDate(resultSet.getDate("ANNEE")));
    }
}
