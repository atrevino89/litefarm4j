package org.litefarm.app.farm_management.domain.location;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public class TotalAreaTest {
    @Test
    public void givenAZeroIsGiven_whenTotalAreaIssCalled_thenThrowBusinessRuleException(){
        Assertions.assertThrows(BusinessRuleException.class, () -> {
            new TotalArea(0);
        });
    }

    @Test
    public void givenAPositiveDoubleValueIsGiven_whenTotalAreaIssCalled_thenTotalAreaIsCreated(){
        var area = 120.00;
        var totalArea = new TotalArea(area);
        Assertions.assertEquals(area, totalArea.value());
    }
}
