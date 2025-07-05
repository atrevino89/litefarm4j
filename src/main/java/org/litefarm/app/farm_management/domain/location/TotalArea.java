package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public record TotalArea (double value) {
    public TotalArea {
        if (value <= 0) throw new BusinessRuleException("Total area has to be a positive number");
    }
}