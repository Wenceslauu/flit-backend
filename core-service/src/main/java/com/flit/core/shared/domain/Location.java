package com.flit.core.shared.domain;

public record Location(double lat, double lng) {

    public Location {
        if (lat < -90 || lat > 90)
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        if (lng < -180 || lng > 180)
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
    }
}
