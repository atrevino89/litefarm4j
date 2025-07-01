package org.litefarm.app.farm_management.domain.location;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.Coordinate;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResidenceTest {
    double totalArea = 123.5;
    CoordinateArea coordinates;
    Unit squareMeter;
    Unit acres;

    @BeforeEach
    void init() {
        this.coordinates = new CoordinateArea(List.of(
                new Coordinate(70.23, 83.3),
                new Coordinate(70.25, 83.3),
                new Coordinate(70.26, 83.3)
        ));
        this.squareMeter = Unit.SQUARE_METERS;
        this.acres = Unit.ACRES;
    }

    @Test
    void givenResidenceValidInformation_whenConsumerCreatesAResidence_thenResidenceIsCreated() {
        var residence = new Residence(
                "Residencia Trevino",
                "Long note in here, lotem ipsum dolorum",
                this.coordinates,
                this.totalArea,
                this.squareMeter

        );

        Assertions.assertNotNull(residence);
        assertEquals(this.totalArea, residence.getTotalArea());
        assertEquals(this.squareMeter, residence.getUnit());
    }

    @Test
    void givenResidenceWithZeroTotalArea_whenConsumerCreatesAResidence_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> new Residence(
                "Residencia Trevino",
                "Long note in here, lotem ipsum dolorum",
                this.coordinates,
                0,
                this.squareMeter)
        );
    }
}
