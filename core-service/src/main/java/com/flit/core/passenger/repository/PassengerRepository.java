package com.flit.core.passenger.repository;

import com.flit.core.passenger.entity.PassengerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerProfile, String> { }
