package org.litefarm.app.farm_management.domain.location;

import java.util.UUID;

public interface BaseLocationIngressData {
        UUID locationUUID();
        String name();
        String note();
        LocationType locationType();

}
