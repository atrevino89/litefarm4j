package org.litefarm.app.farm_management.domain.coordinate;

import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    @Test
    void givenCoordinateObject_whenLatitudeIsMinimumOutOfBoundary_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> {
           new Coordinate(-91, 17.28474);
        });
    }

    @Test
    void givenCoordinateObject_whenLatitudeIsMaximumOutOfBoundary_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> {
            new Coordinate(91, 17.28474);
        });
    }

    @Test
    void givenCoordinateObject_whenLongitudeIsMinimumOutOfBoundary_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> {
            new Coordinate(35, -180.1);
        });
    }

    @Test
    void givenCoordinateObject_whenLongitudeIsMaximumOutOfBoundary_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> {
            new Coordinate(35, 180.1);
        });
    }

    @Test
    void givenCoordinateObject_whenLatitudePrecisionIsMet_thenThrowBusinessRuleException() {
        assertDoesNotThrow(() -> {
            new Coordinate(35.123456789, 180.0);
        });

    }
    @Test
    void givenCoordinateObject_whenLatitudePrecisionIsOutOfBoundary_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> {
            new Coordinate(35.12345678912, 180.0);
        });
    }

    @Test
    void givenCoordinateObject_whenLongitudePrecisionIsOutOfBoundary_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> {
            new Coordinate(45.54, 35.12345678912);
        });
    }

    @Test
    void givenCoordinateObject_whenCallingGetLatitudeCoordinate_thenReturnCorrectValue() {
        double lat = 45.54;
        double lon = 35.5124;
        var coordinate = new Coordinate(lat, lon);
        assertEquals(coordinate.getLatitude(), lat);
    }

    @Test
    void givenCoordinateObject_whenCallingGetLongitudeCoordinate_thenReturnCorrectValue() {
        double lat = 45.54;
        double lon = 35.5124;
        var coordinate = new Coordinate(lat, lon);
        assertEquals(coordinate.getLongitude(), lon);
    }
}
