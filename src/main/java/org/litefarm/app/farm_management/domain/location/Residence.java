package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public class Residence extends Location {
    private double totalArea;
    private Unit unit;

    public Residence(String name, String note, CoordinateArea coordinates, double totalArea, Unit unit) {
        super(name, note, coordinates);

        if(totalArea <= 0) throw new BusinessRuleException("Total area has to be a positive number");
        this.totalArea = totalArea;
        this.unit = unit;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
