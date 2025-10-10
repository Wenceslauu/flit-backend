package com.flit.core.pricing.controller;

import com.flit.core.pricing.dto.request.FareEstimatesRequestDTO;
import com.flit.core.pricing.dto.response.FareEstimatesResponseDTO;
import com.flit.core.pricing.mapper.PricingMapper;
import com.flit.core.pricing.service.PricingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pricing")
public class PricingController {
    private final PricingService pricingService;
    private final PricingMapper pricingMapper;

    public PricingController(PricingService pricingService, PricingMapper pricingMapper) {
        this.pricingService = pricingService;
        this.pricingMapper = pricingMapper;
    }

    @PostMapping(path = "/estimate")
    ResponseEntity<FareEstimatesResponseDTO> estimateFares(@RequestBody FareEstimatesRequestDTO requestBody) {
        var fareEstimates = pricingService.estimateFares();

        var responseBody = pricingMapper.fareEstimatesViewToResponse(fareEstimates);

        return ResponseEntity.ok(responseBody);
    }
}
