package org.litefarm.app.farm_management.domain.coordinate;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoordinateArea implements CoordinateProfile {
    private final List<Coordinate> coordinates;

    public CoordinateArea(List<Coordinate> coords) {
        if (coords == null || coords.size() < 3) {
            throw new BusinessRuleException("More than 2 coordinate points are needed to build a coordinate area");
        }
        this.coordinates = new ArrayList<>(coords);
    }

    @Override
    public Boolean isArea() {
        return true;
    }

    @Override
    public Boolean isPoint() {
        return false;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return Collections.unmodifiableList(coordinates);
    }
}
