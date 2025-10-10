package com.flit.core.pricing.dto.view;

import com.flit.core.trip.enums.RideType;

import java.util.List;

public record FareEstimatesViewDTO(List<FareEstimate> fareEstimates) {

    public record FareEstimate(RideType rideType, double estimatedPrice, int estimatedTimeMinutes) { }
}
