package org.litefarm.app.farm_management.infra.rest.v1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FarmRestController {

    @PostMapping("/farm")
    public ResponseEntity<FarmCreationResponse> createFarm(@RequestBody @Valid FarmCreationRequest farmCreationRequest) {
        return ResponseEntity.ok(
                new FarmCreationResponse(
                        "alan",
                        "lorem ipsum",
                        "98.1290,-389.23",
                        "imperial"
                )
        );
    }


    public static record FarmCreationRequest (
            @NotBlank String name,
            String note,
            String coordinates,
            String units
    ) {}

    public static record FarmCreationResponse (
            String name,
            String note,
            String coordinates,
            String units
    ) {}
}
