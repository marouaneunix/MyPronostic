package fr.norsys.pronostic.dao.role;

import org.springframework.stereotype.Repository;

import fr.norsys.pronostic.domain.Role;

import java.util.Optional;

@Repository
public interface RoleDao {
    Optional<Role> getById(Long id);
}
