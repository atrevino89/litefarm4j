package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

import java.util.UUID;

public abstract class Location {
    private UUID locationUUID;
    private String name, note;
    private CoordinateProfile coordinates;

    public Location(String name, String note, CoordinateProfile coordinates) {
        this.name = name;
        this.note = note;
        this.coordinates = coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCoordinates(CoordinateProfile coordinates) {
        this.coordinates = coordinates;
    }

    CoordinateProfile getCoordinates() {
        return this.coordinates;
    }

    public UUID getLocationUUID() {
        return locationUUID;
    }

    public void setLocationUUID(UUID locationUUID) {
        this.locationUUID = locationUUID;
    }
}
