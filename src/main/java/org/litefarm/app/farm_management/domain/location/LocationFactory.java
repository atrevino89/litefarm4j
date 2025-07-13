package org.litefarm.app.farm_management.domain.location;

public class LocationFactory {
    public static Location createLocation(BaseLocationIngressData ingressData) {
        return switch (ingressData.locationType()) {
            case BARN -> null;
            case CEREMONIAL_AREA -> null;
            case FARM_SITE_BOUNDARY -> null;
            case FIELD -> null;
            case GARDEN -> null;
            case GREENHOUSE -> null;
            case NATURAL_AREA -> null;
            case RESIDENCE -> Residence.of(ingressData);
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
