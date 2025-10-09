package com.flit.core.driver.repository;

import com.flit.core.driver.entity.DriverProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverProfile, String> { }
