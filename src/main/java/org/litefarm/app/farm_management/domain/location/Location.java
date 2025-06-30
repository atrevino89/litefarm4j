package org.litefarm.app.farm_management.domain.location;

public interface Location {
    void setName();
    void setNote();
    void setCoordinates(double lat, double lon);
}
