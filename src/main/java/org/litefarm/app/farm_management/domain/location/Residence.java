package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.Optional;
import java.util.UUID;

public class Residence extends Location {
    private final double totalArea;
    private final Unit unit;

    private Residence(UUID uuid, String name, String note, CoordinateProfile coordinates, Double totalArea, Unit unit) {
        super(uuid, name, note, coordinates);

        if (totalArea <= 0) throw new BusinessRuleException("Total area has to be a positive number");
        this.totalArea = totalArea;
        this.unit = unit;
    }

    public static Residence of(ResidenceIngressData data) {
        return new Residence(
                data.locationUUID(),
                data.name(),
                data.note(),
                data.coordinates(),
                data.totalArea(),
                data.unit()
        );
    }

    public Residence update(ResidenceIngressData d) {
        return new Residence(
                this.getLocationUUID(),
                Optional.ofNullable(d.name()).orElse(this.getName()),
                Optional.ofNullable(d.note()).orElse(this.getNote()),
                Optional.ofNullable(d.coordinates()).orElse((CoordinateArea) this.getCoordinates()),
                Optional.ofNullable(d.totalArea()).orElse(this.getTotalArea()),
                Optional.ofNullable(d.unit()).orElse(this.getUnit())
        );
    }

    public double getTotalArea() {
        return totalArea;
    }

    public Unit getUnit() {
        return unit;
    }
}
