package org.litefarm.app.farm_management.domain;

import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;

import java.util.List;
import java.util.UUID;

// Aggregate root
public class Farm {
    private final UUID farmUUID;
    private final String name;
    private final String phoneNumber;
    private final List<UUID> locations;
    private final String address;
    private final String units;
    private final String currency;
    private final String image;

    private Farm(Builder builder) {
        String exceptionMessage = "Farm %s is required";
        if (builder.farmUUID == null) throw new BusinessRuleException(String.format(exceptionMessage, "uuid"));
        if (builder.name == null || builder.name.isBlank())
            throw new BusinessRuleException(String.format(exceptionMessage, "name"));
        if (builder.phoneNumber == null)
            throw new BusinessRuleException(String.format(exceptionMessage, "phone number"));
        if (builder.address == null) throw new BusinessRuleException(String.format(exceptionMessage, "address"));
        if (builder.units == null) throw new BusinessRuleException(String.format(exceptionMessage, "units"));
        if (builder.currency == null) throw new BusinessRuleException(String.format(exceptionMessage, "currency"));
        if (builder.image == null) throw new BusinessRuleException(String.format(exceptionMessage, "image"));

        this.farmUUID = builder.farmUUID;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.locations = builder.locations;
        this.address = builder.address;
        this.units = builder.units;
        this.currency = builder.currency;
        this.image = builder.image;
    }

    public List<UUID> getLocations() {
        return locations;
    }

    public static class Builder {
        private UUID farmUUID;
        private String name;
        private String phoneNumber;
        private List<UUID> locations;
        private String address;
        private String units;
        private String currency;
        private String image;

        public Builder uuid(UUID uuid) {
            this.farmUUID = uuid;
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

        public Builder locations(List<UUID> locations) {
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
