package com.flit.core.pricing.mapper;

import com.flit.core.pricing.dto.response.FareEstimatesResponseDTO;
import com.flit.core.pricing.dto.view.FareEstimatesViewDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PricingMapper {

    FareEstimatesResponseDTO fareEstimatesViewToResponse(FareEstimatesViewDTO fareEstimatesViewDTO);
}
