package org.litefarm.app.farm_management.domain.coordinate;

import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateAreaTest {
    @Test
    void givenCoordinateList_whenPointsAreLessThan3_thenThrowBusinessRuleException() {
        List<Coordinate> coords = List.of(
                new Coordinate(10, 10),
                new Coordinate(10, 20)
        );
        assertThrows(BusinessRuleException.class, () -> new CoordinateArea(coords));
    }

    @Test
    void givenCoordinateList_whenObjectIsNull_thenThrowBusinessRuleException() {
        List<Coordinate> coords = null;
        assertThrows(BusinessRuleException.class, () -> new CoordinateArea(coords));
    }

    @Test
    void givenCoordinateList_whenPointsAreEqualTo3_thenCoordinateAreaIsCreated() {
        List<Coordinate> coords = List.of(
                new Coordinate(10, 10),
                new Coordinate(10, 20),
                new Coordinate(10, 40)
        );
        assertDoesNotThrow(() -> {
            new CoordinateArea(coords);
        });
    }

    @Test
    void givenCoordinateArea_whenCallIsArea_thenReturnTrue() {
        List<Coordinate> coords = List.of(
                new Coordinate(10, 10),
                new Coordinate(10, 20),
                new Coordinate(10, 40)
        );
        CoordinateProfile coordinateArea = new CoordinateArea(coords);
        assertTrue(coordinateArea.isArea());
    }

    @Test
    void givenCoordinateArea_whenCallIsPoint_thenReturnFalse() {
        List<Coordinate> coords = List.of(
                new Coordinate(10, 10),
                new Coordinate(10, 20),
                new Coordinate(10, 40)
        );
        CoordinateProfile coordinateArea = new CoordinateArea(coords);
        assertFalse(coordinateArea.isPoint());
    }

    @Test
    void givenCoordinateArea_whenCallGetCoordinates_thenReturnImmutableListOfCoordinates() {
        List<Coordinate> coords = List.of(
                new Coordinate(10, 10),
                new Coordinate(10, 20),
                new Coordinate(10, 40)
        );
        CoordinateProfile coordinateArea = new CoordinateArea(coords);
        assertThrows(UnsupportedOperationException.class, () -> coordinateArea.getCoordinates().add(new Coordinate(-10, 10)));
    }
}
