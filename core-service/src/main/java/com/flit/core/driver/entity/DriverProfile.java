package com.flit.core.driver.entity;

import com.flit.core.user.entity.User;
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
@Table(name = "driver_profile", schema = "public")
public class DriverProfile {

    @Id
    @Column(name = "user_id")
    private String id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
