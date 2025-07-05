package org.litefarm.app.farm_management.domain.farm;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.UUID;

public record FarmId(UUID value) {
    public FarmId {
        if (value == null) throw new BusinessRuleException("FarmId cannot be null");
    }
}
