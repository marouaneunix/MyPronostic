package fr.norsys.pronostic.mappers.rencontre;

import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.domain.Poule;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.utils.DateFormat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/28/17.
 */
public class RencontreMapper implements RowMapper<Rencontre> {
    @Override
    public Rencontre mapRow(ResultSet resultSet, int i) throws SQLException {
        Competition competition = new Competition(resultSet.getLong("ID_COMPETITION"),
                resultSet.getString("COMPETITION_NOM"),
                DateFormat.formatToLocalDate(resultSet.getDate("ANNEE")));
        Poule poule= new Poule(resultSet.getLong("ID_POULE"),
                resultSet.getString("POULE_NOM"),
                resultSet.getBoolean("GROUPE"),competition);

        Pays pays1 = new Pays(resultSet.getLong("PAY1_ID"),
                resultSet.getString("PAY1_NOM"),
                resultSet.getString("PAY1_LOGO"));
        Pays pays2 = new Pays(resultSet.getLong("PAY2_ID"),
                resultSet.getString("PAY2_NOM"),
                resultSet.getString("PAY2_LOGO"));
        return new Rencontre(resultSet.getLong("ID_RENCONTRE"),pays1,pays2,
                resultSet.getInt("BUT_1"),
                resultSet.getInt("BUT_2"),poule,
                DateFormat.formatToLocalDateTime(resultSet.getTimestamp("DATE")));

    }
}
