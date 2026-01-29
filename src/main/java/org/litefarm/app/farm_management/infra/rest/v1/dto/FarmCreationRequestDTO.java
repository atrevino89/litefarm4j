package org.litefarm.app.farm_management.infra.rest.v1.dto;

import jakarta.validation.constraints.NotBlank;

public record FarmCreationRequestDTO(
        @NotBlank(message = "Name must not be blank")
        String name,
        String note,
        @NotBlank(message = "Must not be blank")
        String coordinates,
        @NotBlank(message = "Must not be blank")
        String units,
        String phone,
        String address,
        String currency,
        String imageUrl
) {
}
