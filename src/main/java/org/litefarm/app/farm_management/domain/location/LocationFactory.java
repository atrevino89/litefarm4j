package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

public class LocationFactory {
    public static Location createLocation(LocationType locationType) {
        return switch (locationType) {
            case BARN -> null;
            case CEREMONIAL_AREA -> null;
            case FARM_SITE_BOUNDARY -> null;
            case FIELD -> null;
            case GARDEN -> null;
            case GREENHOUSE -> null;
            case NATURAL_AREA -> null;
            case RESIDENCE -> null;
            case SURFACE_WATER -> null;
            case BUFFER_ZONE -> null;
            case FENCE -> null;
            case WATERCOURSE -> null;
            case GATE -> null;
            case SENSOR -> null;
            case SOIL_SAMPLE_LOCATION -> null;
            case WATER_VALVE -> null;
        };
    }
}
