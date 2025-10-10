package com.flit.core.pricing.service;

import com.flit.core.pricing.dto.view.FareEstimatesViewDTO;
import com.flit.core.trip.enums.RideType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    public FareEstimatesViewDTO estimateFares() {
        var fareEstimates = new FareEstimatesViewDTO(
                List.of(new FareEstimatesViewDTO.FareEstimate(
                        RideType.STANDARD, 10.0, 5))); // Placeholder values

        return fareEstimates;
    }
}
