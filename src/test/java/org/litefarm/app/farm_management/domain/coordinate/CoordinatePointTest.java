package org.litefarm.app.farm_management.domain.coordinate;

import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinatePointTest {
    @Test
    void givenCoordinate_whenObjectIsNull_thenThrowBusinessRuleException() {
        assertThrows(BusinessRuleException.class, () -> new CoordinatePoint(null));
    }

    @Test
    void givenCoordinate_whenObjectIsValid_thenObjectIsCreated() {
        var coord = new Coordinate(-89.32, 100.20);
        var point = new CoordinatePoint(coord);
        assertNotNull(point);
    }

    @Test
    void givenCoordinate_whenCallIsArea_thenReturnFalse() {
        var coord = new Coordinate(-89.32, 100.20);
        var coordPoint = new CoordinatePoint(coord);
        assertFalse(coordPoint.isArea());
    }

    @Test
    void givenCoordinate_whenCallIsPoint_thenReturnTrue() {
        var coord = new Coordinate(-89.32, 100.20);
        var coordPoint = new CoordinatePoint(coord);
        assertTrue(coordPoint.isPoint());
    }

    @Test
    void givenCoordinate_whenCallGetCoordinates_thenReturnImmutableListOfCoordinates() {
        var coord = new Coordinate(-89.32, 100.20);
        var coordinatePoint = new CoordinatePoint(coord);
        assertThrows(UnsupportedOperationException.class, () -> coordinatePoint.getCoordinates().add(new Coordinate(-10, 10)));
    }
}
