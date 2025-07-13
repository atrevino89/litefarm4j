package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

import java.util.Optional;
import java.util.UUID;

public class Residence extends LocationArea {

    private Residence(
            UUID uuid,
            String name,
            String note,
            CoordinateProfile coordinates,
            TotalArea area
    ) {
        super(uuid, name, note, coordinates, area);
    }

    public static Residence of(BaseLocationIngressData baseData) {
        var residenceData = (ResidenceIngressData) baseData;
        return new Residence(
                residenceData.locationUUID(),
                residenceData.name(),
                residenceData.note(),
                residenceData.coordinates(),
                residenceData.totalArea()
        );
    }

    public Residence update(ResidenceIngressData d) {
        return new Residence(
                this.getLocationUUID(),
                Optional.ofNullable(d.name()).orElse(this.getName()),
                Optional.ofNullable(d.note()).orElse(this.getNote()),
                Optional.ofNullable(d.coordinates()).orElse((CoordinateArea) this.getCoordinates()),
                Optional.ofNullable(d.totalArea()).orElse(this.getTotalArea())
        );
    }
}
