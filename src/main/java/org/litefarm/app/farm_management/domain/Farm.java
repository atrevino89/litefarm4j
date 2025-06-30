package org.litefarm.app.farm_management.domain;

import org.litefarm.app.farm_management.domain.location.Location;

import java.util.List;
import java.util.UUID;

// Aggregate root
public class Farm {
    private final UUID uuid;
    private final String name;
    private final String phoneNumber;
    private final String location;
    private final String address;
    private final String units;
    private final String currency;
    private final String image;

    private Farm(Builder builder) {
        String exceptionMessage = "Farm %s is required";
        if (builder.uuid == null) throw new IllegalArgumentException(String.format(exceptionMessage, "uuid"));
        if (builder.name == null || builder.name.isBlank())
            throw new IllegalArgumentException(String.format(exceptionMessage, "name"));
        if (builder.phoneNumber == null)
            throw new IllegalArgumentException(String.format(exceptionMessage, "phone number"));
        if (builder.location == null) throw new IllegalArgumentException(String.format(exceptionMessage, "location"));
        if (builder.address == null) throw new IllegalArgumentException(String.format(exceptionMessage, "address"));
        if (builder.units == null) throw new IllegalArgumentException(String.format(exceptionMessage, "units"));
        if (builder.currency == null) throw new IllegalArgumentException(String.format(exceptionMessage, "currency"));
        if (builder.image == null) throw new IllegalArgumentException(String.format(exceptionMessage, "image"));

        this.uuid = builder.uuid;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.location = builder.location;
        this.address = builder.address;
        this.units = builder.units;
        this.currency = builder.currency;
        this.image = builder.image;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Location> createLocation() {
        return List.of();
    }

    public static class Builder {
        private UUID uuid;
        private String name;
        private String phoneNumber;
        private String location;
        private String address;
        private String units;
        private String currency;
        private String image;

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
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

        public Builder location(String location) {
            this.location = location;
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
