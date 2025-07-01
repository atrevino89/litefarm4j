package org.litefarm.app.farm_management.domain.location;

import org.litefarm.app.farm_management.domain.coordinate.CoordinateProfile;

public interface Location {
    void setName(String name);

    void setNote(String note);

    void setCoordinateProfile(CoordinateProfile coordinate);

    CoordinateProfile getCoordinateProfile();
}
