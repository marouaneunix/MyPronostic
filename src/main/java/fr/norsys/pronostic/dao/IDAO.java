package fr.norsys.pronostic.dao;

import java.util.Optional;

/**
 * Methode abstraite pour les CRUD
 */
import fr.norsys.pronostic.exception.DaoException;

/**
 *
 * DAO génerique qui fournit les méthodes CRUD pour un model T
 * 
 */
public interface IDAO<T> {

	/**
	 *
	 * @param model
	 * @return 1 if created or 0 if not creayed
	 * @throws DaoException
	 */
	int create(T model) throws DaoException;

	/**
	 *
	 * @param model
	 * @throws DaoException
	 */
	void update(T model) throws DaoException;

	/**
	 *
	 * @param id
	 * @return an Optional Object to eliminate null
	 * @throws DaoException
	 */
	Optional<T> getById(Long id) throws DaoException;

	/**
	 *
	 * @param model
	 * @throws DaoException
	 */
	void delete(T model) throws DaoException;

}
