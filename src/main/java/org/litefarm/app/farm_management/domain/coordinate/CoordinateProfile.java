package org.litefarm.app.farm_management.domain.coordinate;

import java.util.List;

public interface CoordinateProfile {
    Boolean isArea();

    Boolean isPoint();

    List<Coordinate> getCoordinates();

}
