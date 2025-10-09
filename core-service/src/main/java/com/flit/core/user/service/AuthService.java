package com.flit.core.user.service;

import com.flit.core.driver.service.DriverService;
import com.flit.core.passenger.service.PassengerService;
import com.flit.core.user.dto.view.TokensViewDto;
import com.flit.core.user.entity.User;
import com.flit.core.user.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final KeycloakService keycloakService;
    private final UserService userService;
    private final PassengerService passengerService;
    private final DriverService driverService;

    public AuthService(KeycloakService keycloakService, UserService userService, PassengerService passengerService, DriverService driverService) {
        this.keycloakService = keycloakService;
        this.userService = userService;
        this.passengerService = passengerService;
        this.driverService = driverService;
    }

    public TokensViewDto login(String email, String password) {
        return keycloakService.getTokens(email, password);
    }

    public void signUp(String email, String password, Role role) {
        String userId = keycloakService.createUserInKc(email, password, role);

        User user = userService.createUser(userId, email);

        if (role.equals(Role.DRIVER)) {
            driverService.createDriverProfile(user);
        } else if (role.equals(Role.PASSENGER)) {
            passengerService.createPassengerProfile(user);
        }
    }
}
