package fr.norsys.pronostic.mappers.poule;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/25/17.
 */
public class PouleMapper implements RowMapper<Poule> {
    @Override
    public Poule mapRow(ResultSet resultSet, int i) throws SQLException {

        Competition competition = new Competition();
        competition.setId(resultSet.getLong("ID_COMPETITION"));
        competition.setNom(resultSet.getString("NOM"));
        competition.setAnnee(DateFormat.formatToLocalDate(resultSet.getDate("ANNEE")));
        return new Poule(
                resultSet.getLong("ID_POULE"),
                resultSet.getString("NOM_POULE"),
                resultSet.getBoolean("GROUPE"),
                competition);
    }
}
