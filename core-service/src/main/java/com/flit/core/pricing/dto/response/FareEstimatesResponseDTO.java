package com.flit.core.pricing.dto.response;

import com.flit.core.trip.enums.RideType;

import java.util.List;

public record FareEstimatesResponseDTO(List<FareEstimate> fareEstimates) {

    public record FareEstimate(RideType rideType, double estimatedPrice, int estimatedTimeMinutes) { }
}
