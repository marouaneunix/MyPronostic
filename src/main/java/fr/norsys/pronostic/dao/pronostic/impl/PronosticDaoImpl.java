package fr.norsys.pronostic.dao.pronostic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import fr.norsys.pronostic.dao.AbstractJpaDAO;
import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.mappers.pronostic.PronosticMapper;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.dao.pronostic.PronosticDao;

import fr.norsys.pronostic.domain.Pronostic;
import fr.norsys.pronostic.exception.DaoException;


@Repository
public class PronosticDaoImpl extends AbstractJpaDAO implements PronosticDao {



	private static final String INSERT_QUERY = "INSERT INTO PRONOSTIC (`BUT_1`, `BUT_2`, `NOTE`, `ID_RENCONTRE`, `ID_SALARIE`) VALUES(?,?,?,?,?)";
	private static final String SELECT_ALL_BY_SALARIE_QUERY = "SELECT " +
			"pr.ID_PRONOSTIC, pr.BUT_1, pr.BUT_2, pr.NOTE, " +
			"sa.ID_SALARIE, sa.NOM as NOM_SALARIE, sa.PRENOM as PRENOM_SALARIE,sa.USERNAME as USERNAME_SALARIE, " +
			"ro.ID_ROLE, ro.NOM as ROLE_NOM, " +
			"re.ID_RENCONTRE,re.DATE, re.BUT_1 as RE_BUT_1, re.BUT_2 as RE_BUT_2, " +
			"pay1.ID_PAYS as PAYS1_ID,pay1.NOM as PAY1_NOM ,pay1.LOGO as PAY1_LOGO, " +
			"pay2.ID_PAYS as PAYS2_ID,pay2.NOM as PAY2_NOM, pay2.LOGO as PAY2_LOGO ," +
			"po.ID_POULE, po.NOM as POULE_NOM, po.GROUPE," +
			"co.ID_COMPETITION, co.NOM as COMPETITION_NOM, co.ANNEE " +
			"FROM PRONOSTIC pr " +
			"LEFT JOIN SALARIE sa on sa.ID_SALARIE = pr.ID_SALARIE " +
			"LEFT JOIN RENCONTRE re on re.ID_RENCONTRE = pr.ID_RENCONTRE " +
			"LEFT JOIN PAYS pay1 on pay1.ID_PAYS = re.ID_PAYS_1 " +
			"LEFT JOIN PAYS pay2 on pay2.ID_PAYS = re.ID_PAYS_2 " +
			"LEFT JOIN ROLE ro on ro.ID_ROLE = sa.ID_ROLE " +
			"LEFT JOIN POULE po on po.ID_POULE = re.ID_POULE " +
			"LEFT JOIN COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION " +
			"WHERE pr.ID_SALARIE = ?";

	public PronosticDaoImpl() {
		setClazz(Pronostic.class);
	}

	@Override
	public List<Pronostic> getAllPronosticsBySalarieId(Long id){
		return this.entityManager.createQuery("from Pronostic as p where p.salarie.id = :idSalarie").setParameter("idSalarie",id).getResultList();
	}


	@Override
	public void createPronostic(Pronostic model)   {
		this.update(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pronostic> getAll() {
		return this.findAll();
	}


}
