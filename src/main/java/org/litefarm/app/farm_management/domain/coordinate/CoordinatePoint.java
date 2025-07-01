package org.litefarm.app.farm_management.domain.coordinate;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.Collections;
import java.util.List;

public class CoordinatePoint implements CoordinateProfile {
    private final Coordinate coordinate;

    public CoordinatePoint(Coordinate coord) {
        if (coord == null) {
            throw new BusinessRuleException("Coord cannot be null");
        }
        this.coordinate = coord;
    }

    @Override
    public Boolean isArea() {
        return false;
    }

    @Override
    public Boolean isPoint() {
        return true;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return Collections.singletonList(this.coordinate);
    }
}
