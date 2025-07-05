package org.litefarm.app.farm_management.domain.location;


import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

import java.util.UUID;

public abstract class LocationArea extends Location {
    private TotalArea totalArea;

    public LocationArea(UUID locationUUID, String name, String note, CoordinateProfile coordinates, TotalArea area) {
        super(locationUUID, name, note, coordinates);

        this.totalArea = area;
    }

    public TotalArea getTotalArea() {
        return this.totalArea;
    }
}
