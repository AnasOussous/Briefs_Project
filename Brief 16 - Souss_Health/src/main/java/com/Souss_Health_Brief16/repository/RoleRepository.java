package com.Souss_Health_Brief16.repository;



import java.util.Optional;

import com.Souss_Health_Brief16.model.ERole;
import com.Souss_Health_Brief16.model.Role;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
