package fr.norsys.pronostic.service.salarie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.norsys.pronostic.dao.salarie.SalarieDao;
import fr.norsys.pronostic.domain.CustomUserDetails;
import fr.norsys.pronostic.domain.Salarie;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AuthenticationServiceImpl implements UserDetailsService {

	@Autowired
	SalarieDao salarieDao;

	public AuthenticationServiceImpl(SalarieDao salarieDao) {
		this.salarieDao = salarieDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Salarie salarie;
		try {
			salarie = this.salarieDao.getSalarieByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Salarie not found"));
		} catch (EmptyResultDataAccessException e) {
			throw new UsernameNotFoundException("Authentication Error ", e);
		}

		return new CustomUserDetails(salarie);
	}
}
