package fr.norsys.pronostic.mappers.pronostic;

import fr.norsys.pronostic.domain.*;
import fr.norsys.pronostic.utils.DateFormat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mar1 on 3/27/17.
 */
public class PronosticMapper implements RowMapper<Pronostic> {
    @Override
    public Pronostic mapRow(ResultSet resultSet, int i) throws SQLException {
        Competition competition = new Competition(resultSet.getLong("ID_COMPETITION"),
                resultSet.getString("COMPETITION_NOM"),
                DateFormat.formatToLocalDate(resultSet.getDate("ANNEE")));
        Role role = new Role(resultSet.getLong("ID_ROLE"),
                resultSet.getString("ROLE_NOM"));
        Salarie salarie = new Salarie(resultSet.getLong("ID_SALARIE"),
                resultSet.getString("NOM_SALARIE"),
                resultSet.getString("PRENOM_SALARIE"),
                resultSet.getString("USERNAME_SALARIE"),
                null,role);
        Pays pays1 = new Pays(resultSet.getLong("PAYS1_ID"),
                resultSet.getString("PAY1_NOM"),
                resultSet.getString("PAY1_LOGO"));
        Pays pays2 = new Pays(resultSet.getLong("PAYS2_ID"),
                resultSet.getString("PAY2_NOM"),
                resultSet.getString("PAY2_LOGO"));
        Poule poule = new Poule(resultSet.getLong("ID_POULE"),
                resultSet.getString("POULE_NOM"),
                resultSet.getBoolean("GROUPE"),
                competition);
        Rencontre rencontre = new Rencontre(resultSet.getLong("ID_RENCONTRE"),
                pays1,pays2,
                resultSet.getInt("RE_BUT_1"),
                resultSet.getInt("RE_BUT_2"),
                poule,
                DateFormat.formatToLocalDateTime(resultSet.getTimestamp("Date")));


        return new Pronostic(resultSet.getLong("ID_PRONOSTIC"),
                resultSet.getInt("BUT_1"),
                resultSet.getInt("BUT_2"),
                resultSet.getInt("NOTE"),
                rencontre,salarie);
    }
}
