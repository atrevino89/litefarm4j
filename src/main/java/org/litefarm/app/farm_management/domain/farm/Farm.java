package org.litefarm.app.farm_management.domain.farm;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;
import org.litefarm.app.farm_management.domain.location.BaseLocationIngressData;
import org.litefarm.app.farm_management.domain.location.Location;
import org.litefarm.app.farm_management.domain.location.LocationFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Aggregate root
public class Farm {
    private final FarmId farmId;
    private final String name;
    private final String phoneNumber;
    private final String address;
    private final String units;
    private final String currency;
    private final String image;
    private final ArrayList<UUID> locations;

    private Farm(Builder builder) {
        String exceptionMessage = "Farm %s is required";
        if (builder.farmId == null) throw new BusinessRuleException(String.format(exceptionMessage, "uuid"));
        if (builder.name == null || builder.name.isBlank())
            throw new BusinessRuleException(String.format(exceptionMessage, "name"));
        if (builder.phoneNumber == null)
            throw new BusinessRuleException(String.format(exceptionMessage, "phone number"));
        if (builder.address == null) throw new BusinessRuleException(String.format(exceptionMessage, "address"));
        if (builder.units == null) throw new BusinessRuleException(String.format(exceptionMessage, "units"));
        if (builder.currency == null) throw new BusinessRuleException(String.format(exceptionMessage, "currency"));
        if (builder.image == null) throw new BusinessRuleException(String.format(exceptionMessage, "image"));

        this.farmId = builder.farmId;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.locations = Optional.ofNullable(builder.locations).orElse(new ArrayList<>());
        this.address = builder.address;
        this.units = builder.units;
        this.currency = builder.currency;
        this.image = builder.image;
    }

    public List<UUID> getLocations() {
        return locations;
    }

    public Location createLocation(BaseLocationIngressData ingressData) {
        var location = LocationFactory.createLocation(ingressData);
        this.locations.add(location.getLocationUUID());
        return location;
    }

    public static class Builder {
        private FarmId farmId;
        private String name;
        private String phoneNumber;
        private ArrayList<UUID> locations;
        private String address;
        private String units;
        private String currency;
        private String image;

        public Builder farmId(FarmId farmId) {
            this.farmId = farmId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;

        }

        public Builder locations(ArrayList<UUID> locations) {
            this.locations = locations;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder units(String units) {
            this.units = units;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Farm build() {
            return new Farm(this);
        }

    }
}
