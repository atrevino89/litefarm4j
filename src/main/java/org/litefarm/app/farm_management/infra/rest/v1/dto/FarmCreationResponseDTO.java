package org.litefarm.app.farm_management.infra.rest.v1.dto;

import org.litefarm.app.farm_management.domain.farm.FarmId;

public record FarmCreationResponseDTO(
        FarmId farmId
) {
}