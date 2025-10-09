package com.flit.core.driver.service;

import com.flit.core.driver.entity.DriverProfile;
import com.flit.core.driver.repository.DriverRepository;
import com.flit.core.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public DriverProfile createDriverProfile(User user) {
        DriverProfile driverProfile = new DriverProfile();

        driverProfile.setUser(user);

        return driverRepository.save(driverProfile);
    }
}
