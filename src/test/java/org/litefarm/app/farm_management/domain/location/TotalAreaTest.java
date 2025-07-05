package org.litefarm.app.farm_management.domain.location;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public class TotalAreaTest {
    @Test
    public void givenAZeroIsGiven_whenTotalAreaIssCalled_thenThrowBusinessRuleException(){
        Assertions.assertThrows(BusinessRuleException.class, () -> {
            new TotalArea(0, Unit.SQUARE_METERS);
        });
    }

    @Test
    public void givenAPositiveDoubleValueIsGiven_whenTotalAreaIssCalled_thenTotalAreaIsCreated(){
        var area = 120.00;
        var units = Unit.ACRES;
        var totalArea = new TotalArea(area, units);
        Assertions.assertEquals(area, totalArea.value());
        Assertions.assertEquals(units, totalArea.unit());
    }
}
