package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public record TotalArea (double value, Unit unit) {
    public TotalArea {
        if (value <= 0) throw new BusinessRuleException("Total area has to be a positive number");
        if (unit == null) throw new BusinessRuleException("Unit has to be given");
    }
}