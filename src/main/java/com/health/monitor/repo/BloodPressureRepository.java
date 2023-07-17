package com.health.monitor.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.health.monitor.model.BloodPressure;

public interface BloodPressureRepository extends JpaRepository<BloodPressure, UUID>{

}
