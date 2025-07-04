package org.litefarm.app.farm_management.domain.location;


import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

import java.util.UUID;

public abstract class LocationArea extends Location {
    private TotalArea totalArea;

    public LocationArea(UUID locationUUID, String name, String note, CoordinateProfile coordinates) {
        super(locationUUID, name, note, coordinates);
    }

    public TotalArea getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(TotalArea totalArea) {
        this.totalArea = totalArea;
    }
}
