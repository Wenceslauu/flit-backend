package com.flit.core.user.entity;

import com.flit.core.driver.entity.DriverProfile;
import com.flit.core.passenger.entity.PassengerProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "public")
public class User {

    @Id
    private String id; // Keycloak's UUID

    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PassengerProfile passengerProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DriverProfile driverProfile;
}
