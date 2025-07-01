package org.litefarm.app.farm_management.domain.coordinate;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.math.BigDecimal;

public class Coordinate {
    private final double latitude, longitude;
    private final int MAX_DECIMAL_PRECISION = 10;

    public Coordinate(double lat, double lon) {
        if (lat < -90.0 || lat > 90.0)
            throw new BusinessRuleException("Latitude must be greater than -90.0 and lesser than 90.0");
        if (lon < -180.0 || lon > 180.0)
            throw new BusinessRuleException("Longitude must be greater than -180.0 and lesser than 180.0");
        String decimalExceptionMessage = String.format("Coordinates maximum decimal precision is %s", MAX_DECIMAL_PRECISION);
        if (isMaxDecimalPrecision(lat) || isMaxDecimalPrecision(lon))
            throw new BusinessRuleException(decimalExceptionMessage);
        this.latitude = lat;
        this.longitude = lon;
    }

    private boolean isMaxDecimalPrecision(double value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        return bigDecimal.scale() > MAX_DECIMAL_PRECISION;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
