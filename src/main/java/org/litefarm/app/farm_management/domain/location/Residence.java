package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

import java.util.UUID;

public class Residence implements Location {
    private UUID residenceUUID;
    private String name, note;
    private double totalArea = 0.00;
    private CoordinateProfile coordinate;
    private Unit unit = null;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public void setCoordinateProfile(CoordinateProfile coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public CoordinateProfile getCoordinateProfile() {
        return this.coordinate;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
