package com.flit.core.pricing.dto.request;

import com.flit.core.shared.domain.Location;

public record FareEstimatesRequestDTO(Location pickupLocation, Location dropoffLocation) { }
