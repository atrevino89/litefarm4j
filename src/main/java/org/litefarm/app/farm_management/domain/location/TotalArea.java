package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public record TotalArea (double totalArea) {
    public TotalArea {
        if (totalArea <= 0) throw new BusinessRuleException("Total area has to be a positive number");
    }
}