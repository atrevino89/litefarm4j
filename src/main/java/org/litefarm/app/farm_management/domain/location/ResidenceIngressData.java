package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;

import java.util.UUID;

public record ResidenceIngressData(
        UUID locationUUID,
        String name,
        String note,
        CoordinateArea coordinates,
        TotalArea totalArea) {
}
