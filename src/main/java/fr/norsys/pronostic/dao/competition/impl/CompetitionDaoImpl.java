package fr.norsys.pronostic.dao.competition.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mar1 on 3/18/17.
 */

import fr.norsys.pronostic.dao.competition.CompetitionDao;
import fr.norsys.pronostic.domain.Competition;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;
import fr.norsys.pronostic.utils.DateFormat;

@Repository
public class CompetitionDaoImpl implements CompetitionDao {

	private static final String SELECT_ALL_COMPETITON_QUERY = "SELECT ID_COMPETITION,NOM,ANNEE FROM COMPETITION";
	private static final String SELECT_BY_ID_QUERY = "SELECT ID_COMPETITION,NOM,ANNEE FROM COMPETITION WHERE ID_COMPETITION = ?";
	private static final Logger LOGGER = LoggerFactory.getLogger(CompetitionDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public int create(Competition model) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Competition model) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Competition> getById(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Connection con = null;
		Competition competition;

		try {
			con = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(con, SELECT_BY_ID_QUERY, false, id);
			rs = preparedStatement.executeQuery();
			rs.next();
			competition = new Competition(rs.getLong("ID_COMPETITION"), rs.getString("NOM"),
					DateFormat.formatToLocalDate(rs.getDate(3)));

		} catch (SQLException e) {
			LOGGER.error("ERROR : {}", e.getMessage());
			throw new DaoException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR {}", e.getMessage());
			}
		}

		return Optional.ofNullable(competition);
	}

	@Override
	public void delete(Competition model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Competition> getAll() throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Connection con = null;
		List<Competition> competitions = new ArrayList<>();

		try {
			con = this.dataSource.getConnection();
			preparedStatement = con.prepareStatement(SELECT_ALL_COMPETITON_QUERY);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				competitions.add(
						new Competition(rs.getLong(1), rs.getString(2), DateFormat.formatToLocalDate(rs.getDate(3))));
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR {}", e.getMessage());
			}
		}
		return competitions;
	}

}
