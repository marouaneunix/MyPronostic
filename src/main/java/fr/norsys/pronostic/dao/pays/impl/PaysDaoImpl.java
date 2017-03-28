package fr.norsys.pronostic.dao.pays.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.mappers.pays.PaysMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.pays.PaysDao;
import fr.norsys.pronostic.domain.Pays;
import fr.norsys.pronostic.exception.DaoException;
import fr.norsys.pronostic.utils.DaoUtils;

@Repository
public class PaysDaoImpl extends JdbcConfig implements PaysDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaysDaoImpl.class);

	private static final String SELECT_QUERY = " SELECT ID_PAYS,NOM,LOGO FROM PAYS WHERE ID_PAYS = ?";
	private static final String SELECT_PAYS_FROM_POULE = " SELECT  pa.ID_PAYS , pa.NOM  , pa.LOGO from PAYS pa 	 INNER JOIN POULE_PAYS pp on pp.ID_PAYS = pa.ID_PAYS  INNER JOIN POULE po on po.ID_POULE = pp.ID_POULE  WHERE po.ID_POULE = ? ";



	@Override
	public int create(Pays model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Pays model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Pays> getById(Long id) throws DaoException {
		Pays pays = null;
		try{
			pays = this.jdbcTemplate.queryForObject(SELECT_QUERY,new Object[]{id},new PaysMapper());
		}catch (EmptyResultDataAccessException e){
			throw  new DaoException("getById Pays exception",e);
		}
		return Optional.ofNullable(pays);
	}

	@Override
	public void delete(Pays model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Pays> getPaysByPoule(Long id) throws DaoException {
		return this.jdbcTemplate.query(SELECT_PAYS_FROM_POULE ,new Object[]{id},new PaysMapper());
	}
}
