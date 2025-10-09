package com.flit.core.passenger.service;

import com.flit.core.passenger.entity.PassengerProfile;
import com.flit.core.passenger.repository.PassengerRepository;
import com.flit.core.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public PassengerProfile createPassengerProfile(User user) {
        PassengerProfile passengerProfile = new PassengerProfile();

        passengerProfile.setUser(user);

        return passengerRepository.save(passengerProfile);
    }
}
