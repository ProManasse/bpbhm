package com.health.monitor.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.health.monitor.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	  Optional<User> findByUsername(String username);
	  Boolean existsByUsername(String username);
}
