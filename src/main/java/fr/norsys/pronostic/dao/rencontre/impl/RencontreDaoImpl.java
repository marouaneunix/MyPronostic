package fr.norsys.pronostic.dao.rencontre.impl;

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

import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.dao.poule.PouleDao;
import fr.norsys.pronostic.dao.rencontre.RencontreDao;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;
import fr.norsys.pronostic.utils.DateFormat;

@Repository
public class RencontreDaoImpl implements RencontreDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RencontreDaoImpl.class);

	private static final String SELECT_QUERY = "SELECT ID_RENCONTRE,DATE,ID_PAYS_1,BUT_1,BUT_2,ID_PAYS_2,ID_POULE FROM RENCONTRE WHERE ID_RENCONTRE = ?";
	private static final String SELECT_ALL_BY_POULE = "SELECT ID_RENCONTRE,DATE,ID_PAYS_1,BUT_1,BUT_2,ID_PAYS_2,ID_POULE FROM RENCONTRE WHERE ID_POULE = ?";
	private static final String SELECT_ALL_QUERY = "SELECT ID_RENCONTRE,DATE,ID_PAYS_1,BUT_1,BUT_2,ID_PAYS_2,ID_POULE FROM RENCONTRE";
	private static final String SELECT_ALL_NON_PRONOSTIQUER_BY_ID_POULE = "SELECT rc.ID_RENCONTRE,rc.DATE,rc.BUT_1,rc.BUT_2,rc.ID_PAYS_1,rc.ID_PAYS_2,rc.ID_POULE FROM RENCONTRE rc\n"
			+ "left JOIN (select ID_PRONOSTIC,ID_RENCONTRE from PRONOSTIC pro  inner join SALARIE sal on pro.ID_SALARIE = sal.ID_SALARIE where sal.ID_SALARIE = ? ) pr ON rc.ID_RENCONTRE = pr.ID_RENCONTRE\n"
			+ "WHERE  pr.ID_PRONOSTIC IS NULL and rc.DATE and rc.ID_POULE = ? and  TIMESTAMPDIFF(MINUTE,now(),rc.DATE) >= 15";
	private static final String ID_RENCONTRE_COLUMN_NAME = "ID_RENCONTRE";
	private static final String ID_PAYS_1_COLUMN_NAME = "ID_PAYS_1";
	private static final String ID_PAYS_2_COLUMN_NAME = "ID_PAYS_2";
	private static final String BUT_1_COLUMN_NAME = "BUT_1";
	private static final String BUT_2_COLUMN_NAME = "BUT_2";
	private static final String ID_POULE_COLUMN_NAME = "ID_POULE";
	private static final String DATE_COLUMN_NAME = "DATE";

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PaysDao paysDao;

	@Autowired
	private PouleDao pouleDao;

	@Override
	public int create(Rencontre model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Rencontre model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Rencontre> getById(Long id) throws DaoException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Rencontre rencontre;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_QUERY, false, id);
			rs = preparedStatement.executeQuery();
			rs.next();
			rencontre = new Rencontre(rs.getLong(ID_RENCONTRE_COLUMN_NAME),
					this.paysDao.getById(rs.getLong(ID_PAYS_1_COLUMN_NAME)).get(),
					this.paysDao.getById(rs.getLong(ID_PAYS_2_COLUMN_NAME)).get(), rs.getInt(BUT_1_COLUMN_NAME),
					rs.getInt(BUT_2_COLUMN_NAME), this.pouleDao.getById(rs.getLong(ID_POULE_COLUMN_NAME)).get(),
					DateFormat.formatToLocalDateTime(rs.getTimestamp(DATE_COLUMN_NAME)));

		} catch (SQLException e) {
			throw new DaoException("getByID Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}

		return Optional.ofNullable(rencontre);
	}

	@Override
	public void delete(Rencontre model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Rencontre> getAll() throws DaoException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);

		} catch (SQLException e) {
			throw new DaoException("getALL Not working SQLException", e);
		}

		return this.getRencontres(connection, preparedStatement);
	}

	@Override
	public List<Rencontre> getAllByIdPoule(long id) throws DaoException {
		return this.getRencontreByCriteria(id);
	}

	@Override
	public List<Rencontre> getAllRencontresNonPronostiquerParPouleID(long idSalarie, long idPoule) throws DaoException {
		return this.getRencontreByCriteria(idSalarie, idPoule);
	}

	/**
	 * cette methode permet de retourner une list des rencontres basé sur les
	 * nombres d'arguments passé en paramétre
	 *
	 * @param objects
	 *            : tables of paramertes
	 * @return list of Rencontres
	 * @throws DaoException
	 */
	private List<Rencontre> getRencontreByCriteria(Object... objects) throws DaoException {
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			connection = this.dataSource.getConnection();
			if (objects.length == 1) {
				preparedStatement = DaoUtils.initialisationRequetePreparee(connection, SELECT_ALL_BY_POULE, false,
						objects[0]);
			} else {
				preparedStatement = DaoUtils.initialisationRequetePreparee(connection,
						SELECT_ALL_NON_PRONOSTIQUER_BY_ID_POULE, false, objects[0], objects[1]);
			}
		} catch (SQLException e) {
			throw new DaoException("getRencontreByCriteria Not working SQLException", e);
		}

		return this.getRencontres(connection, preparedStatement);
	}

	/**
	 * executer la requête et retourner la list des rencontres
	 *
	 * @param connection
	 * @param preparedStatement
	 * @return
	 * @throws DaoException
	 */
	private List<Rencontre> getRencontres(Connection connection, PreparedStatement preparedStatement)
			throws DaoException {
		ResultSet rs;
		List<Rencontre> rencontres = new ArrayList<>();
		try {
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				rencontres.add(new Rencontre(rs.getLong(ID_RENCONTRE_COLUMN_NAME),
						this.paysDao.getById(rs.getLong(ID_PAYS_1_COLUMN_NAME)).get(),
						this.paysDao.getById(rs.getLong(ID_PAYS_2_COLUMN_NAME)).get(), rs.getInt(BUT_1_COLUMN_NAME),
						rs.getInt(BUT_2_COLUMN_NAME), this.pouleDao.getById(rs.getLong(ID_POULE_COLUMN_NAME)).get(),
						DateFormat.formatToLocalDateTime(rs.getTimestamp(DATE_COLUMN_NAME))));
			}
		} catch (SQLException e) {
			throw new DaoException("getRencontres Not working SQLException", e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("ERROR : {}", e.getMessage());
			}
		}
		return rencontres;
	}
}
