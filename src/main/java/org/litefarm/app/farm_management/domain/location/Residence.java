package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;

import java.util.UUID;

public class Residence implements Location {
    private UUID residenceUUID;
    private String name, note;
    private double lat, lon, totalArea;
    private Unit unit = null;

    @Override
    public void setName() {
        this.name = name;
    }

    @Override
    public void setNote() {
        this.note = note;
    }

    @Override
    public void setCoordinates(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public void setTotalArea(double totalArea) {
            this.totalArea = totalArea;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
