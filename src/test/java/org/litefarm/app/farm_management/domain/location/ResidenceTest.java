package org.litefarm.app.farm_management.domain.location;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.Coordinate;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ResidenceTest {
    private TotalArea totalArea;
    private CoordinateArea coordinates;

    private ResidenceIngressData residenceIngressData;
    private Residence oldResidence;

    @BeforeEach
    void init() {
        this.totalArea = new TotalArea(123.4, Unit.SQUARE_METERS);
        this.coordinates = new CoordinateArea(List.of(
                new Coordinate(70.23, 83.3),
                new Coordinate(70.25, 83.3),
                new Coordinate(70.26, 83.3)
        ));
        var acres = Unit.ACRES;

        this.residenceIngressData = new ResidenceIngressData(
                UUID.randomUUID(),
                "Residencia Trevino",
                "Long note in here, lotem ipsum dolorum",
                this.coordinates,
                this.totalArea,
                LocationType.RESIDENCE
        );

        this.oldResidence = Residence.of(
                residenceIngressData
        );
    }

    @Test
    void givenResidenceValidInformation_whenConsumerCreatesAResidence_thenResidenceIsCreated() {
        var residence = Residence.of(
                residenceIngressData
        );


        Assertions.assertNotNull(residence);
        assertEquals(this.totalArea.value(), residence.getTotalArea().value());
        assertEquals(this.totalArea.unit(), residence.getTotalArea().unit());
    }

    @Test
    void givenResidenceValidInformation_whenUpdatingAResidence_thenUpdatedResidenceIsCreated() {
        var newCoordinates = new CoordinateArea(List.of(
                new Coordinate(70.23, 83.3),
                new Coordinate(70.25, 83.3),
                new Coordinate(70.26, 83.3)
        ));

        var newRandomUUID = UUID.randomUUID();
        var newResidenceData = new ResidenceIngressData(
                newRandomUUID,
                "Alameda disco",
                "Updated note",
                newCoordinates,
                new TotalArea(10.00, Unit.ACRES),
                LocationType.RESIDENCE
        );

        var newResidence = oldResidence.update(newResidenceData);

        assertNotEquals(newRandomUUID, newResidence.getLocationUUID());
        assertEquals(newResidenceData.name(), newResidence.getName());
        assertEquals(newResidenceData.note(), newResidence.getNote());
        assertEquals(newResidenceData.coordinates(), newResidence.getCoordinates());
        assertEquals(newResidenceData.totalArea(), newResidence.getTotalArea());
    }

    @Test
    void givenExistingResidence_whenUpdatingAResidenceWithPartialInfo_thenUpdatedResidenceIsCreated() {
        var newRandomUUID = UUID.randomUUID();
        var newResidenceData = new ResidenceIngressData(
                newRandomUUID,
                "Alameda disco",
                "Updated note",
                null,
                null,
                LocationType.RESIDENCE
        );

        var newResidence = oldResidence.update(newResidenceData);


        // from the old entity or unchanged values
        assertNotEquals(newRandomUUID, newResidence.getLocationUUID());
        assertEquals(oldResidence.getCoordinates(), newResidence.getCoordinates());
        assertEquals(oldResidence.getTotalArea(), newResidence.getTotalArea());
        assertEquals(oldResidence.getTotalArea(), newResidence.getTotalArea());

        // validating updated values
        assertEquals(newResidenceData.name(), newResidence.getName());
        assertEquals(newResidenceData.note(), newResidence.getNote());

    }
}
