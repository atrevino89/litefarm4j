package org.litefarm.app.farm_management.infra.rest.v1;

import jakarta.validation.Valid;
import org.litefarm.app.farm_management.domain.farm.Farm;
import org.litefarm.app.farm_management.domain.farm.FarmId;
import org.litefarm.app.farm_management.infra.rest.v1.dto.FarmCreationRequestDTO;
import org.litefarm.app.farm_management.infra.rest.v1.dto.FarmCreationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class FarmRestController {

    @PostMapping("farm")
    public ResponseEntity<FarmCreationResponseDTO> createFarm(
            @RequestBody @Valid
            FarmCreationRequestDTO farmCreationRequest
    ) {
        Farm farm = null;
        try {
            farm = new Farm.Builder()
                    .farmId(new FarmId(UUID.randomUUID()))
                    .name(farmCreationRequest.name())
                    .phoneNumber(farmCreationRequest.phone())
                    .address(farmCreationRequest.address())
                    .units(farmCreationRequest.units())
                    .currency(farmCreationRequest.currency())
                    .image(farmCreationRequest.imageUrl())
                    .build();
        } catch (Exception ex) {
            System.out.println(farm);
        }


        return ResponseEntity.ok(
                new FarmCreationResponseDTO(farm.getFarmId())
        );
    }
}
