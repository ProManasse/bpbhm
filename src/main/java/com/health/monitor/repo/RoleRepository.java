package com.health.monitor.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.health.monitor.model.ERole;
import com.health.monitor.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	  Optional<Role> findByName(ERole name);
}

