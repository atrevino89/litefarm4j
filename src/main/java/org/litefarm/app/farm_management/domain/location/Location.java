package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

import java.util.UUID;

public abstract class Location {
    private final UUID locationUUID;
    private final String name;
    private final String note;
    private final CoordinateProfile coordinates;

    public Location(UUID locationUUID, String name, String note, CoordinateProfile coordinates) {
        this.locationUUID = locationUUID;
        this.name = name;
        this.note = note;
        this.coordinates = coordinates;
    }

    public CoordinateProfile getCoordinates() {
        return this.coordinates;
    }

    public UUID getLocationUUID() {
        return this.locationUUID;
    }


    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }
}
