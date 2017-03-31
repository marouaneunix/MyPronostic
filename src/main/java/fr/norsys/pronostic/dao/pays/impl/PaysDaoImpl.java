package fr.norsys.pronostic.dao.pays.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import fr.norsys.pronostic.dao.AbstractJpaDAO;
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
public class PaysDaoImpl extends AbstractJpaDAO<Pays> implements PaysDao {




	public PaysDaoImpl() {
		setClazz(Pays.class);
	}

	@Override
	public Optional<Pays> getById(Long id)  {
		return this.findOne(id);
	}



	@Override
	public List<Pays> getPaysByPoule(Long id)   {
		return this.entityManager.createQuery("Select p.payss from Poule as p where p.id = :idPoule").setParameter("idPoule",id).getResultList();
	}
}
