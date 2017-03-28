package fr.norsys.pronostic.dao.rencontre.impl;

import java.util.List;
import java.util.Optional;



import fr.norsys.pronostic.dao.JdbcConfig;
import fr.norsys.pronostic.mappers.rencontre.RencontreMapper;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;


import fr.norsys.pronostic.dao.rencontre.RencontreDao;
import fr.norsys.pronostic.domain.Rencontre;
import fr.norsys.pronostic.exception.DaoException;


@Repository
public class RencontreDaoImpl extends JdbcConfig implements RencontreDao {



	private static final String SELECT = "select re.ID_RENCONTRE,re.DATE,re.BUT_1,re.BUT_2, " +
			"pay1.ID_PAYS as PAY1_ID,pay1.NOM as PAY1_NOM, pay1.LOGO as PAY1_LOGO, " +
			"pay2.ID_PAYS as PAY2_ID,pay2.NOM as PAY2_NOM, pay2.LOGO as PAY2_LOGO, " +
			"po.ID_POULE, po.NOM as POULE_NOM, po.GROUPE, " +
			"co.ID_COMPETITION, co.NOM COMPETITION_NOM, co.ANNEE " +
			"from RENCONTRE re " +
			"LEFT JOIN PAYS pay1 on pay1.ID_PAYS = re.ID_PAYS_1 " +
			"LEFT JOIN PAYS pay2 on pay2.ID_PAYS = re.ID_PAYS_2 " +
			"LEFT JOIN POULE po on po.ID_POULE = re.ID_POULE " +
			"LEFT JOIN COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION ";

	private static final String SELECT_QUERY =  SELECT+"WHERE re.ID_RENCONTRE = ?";
	private static final String SELECT_ALL_BY_POULE = SELECT+"WHERE re.ID_POULE = ?";
	private static final String SELECT_ALL_QUERY = SELECT;


	private static final String SELECT_ALL_NON_PRONOSTIQUER_BY_ID_POULE = "SELECT re.ID_RENCONTRE,re.DATE,re.BUT_1,re.BUT_2, " +
			"pay1.ID_PAYS as PAY1_ID,pay1.NOM as PAY1_NOM, pay1.LOGO as PAY1_LOGO," +
			"pay2.ID_PAYS as PAY2_ID,pay2.NOM as PAY2_NOM, pay2.LOGO as PAY2_LOGO, " +
			"po.ID_POULE, po.NOM as POULE_NOM, po.GROUPE, " +
			"co.ID_COMPETITION, co.NOM COMPETITION_NOM, co.ANNEE " +
			"from RENCONTRE re " +
			"left JOIN (select ID_PRONOSTIC,ID_RENCONTRE from PRONOSTIC pro  inner join SALARIE sal on pro.ID_SALARIE = sal.ID_SALARIE where sal.ID_SALARIE = ? ) pr ON re.ID_RENCONTRE = pr.ID_RENCONTRE\n" +
			"LEFT JOIN PAYS pay1 on pay1.ID_PAYS = re.ID_PAYS_1" +
			"LEFT JOIN PAYS pay2 on pay2.ID_PAYS = re.ID_PAYS_2" +
			"LEFT JOIN POULE po on po.ID_POULE = re.ID_POULE" +
			"LEFT JOIN COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION" +
			"WHERE  pr.ID_PRONOSTIC IS NULL and re.DATE and re.ID_POULE = ? and  TIMESTAMPDIFF(MINUTE,now(),re.DATE) >= 15";


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
		Rencontre rencontre = null;
		try{
			rencontre = this.jdbcTemplate.queryForObject(SELECT_QUERY,new Object[]{id},new RencontreMapper());
		}catch (EmptyResultDataAccessException e){
			throw new DaoException("rencontre not found ",e);
		}
		return Optional.ofNullable(rencontre);
	}

	@Override
	public void delete(Rencontre model) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Rencontre> getAll() {
		return this.jdbcTemplate.query(SELECT_ALL_QUERY,new RencontreMapper());
	}

	@Override
	public List<Rencontre> getAllByIdPoule(long id) {
		return this.jdbcTemplate.query(SELECT_ALL_BY_POULE,new Object[]{id}, new RencontreMapper());
	}

	@Override
	public List<Rencontre> getAllRencontresNonPronostiquerParPouleID(long idSalarie, long idPoule)  {
		return this.jdbcTemplate.query(SELECT_ALL_NON_PRONOSTIQUER_BY_ID_POULE,new Object[]{idSalarie,idPoule}, new RencontreMapper());
	}


}
