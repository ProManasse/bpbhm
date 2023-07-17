package com.health.monitor.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.health.monitor.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
}
