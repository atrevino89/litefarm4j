package org.litefarm.app.farm_management.domain.farm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.UUID;

public class FarmIdTest {
    @Test
    void givenFarmId_whenNullIsPassed_thenBusinessRuleExceptionIsThrown() {
        Assertions.assertThrows(BusinessRuleException.class, () -> {
            new FarmId(null);
        });
    }

    @Test
    void givenFarmId_whenUUIDIsPassed_thenFarmIdIsCreated() {
        var uuid = UUID.randomUUID();
        var farmId = new FarmId(uuid);
        Assertions.assertEquals(uuid, farmId.value());
    }
}
