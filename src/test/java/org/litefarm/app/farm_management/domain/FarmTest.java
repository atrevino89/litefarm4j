package org.litefarm.app.farm_management.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.location.Location;
import org.litefarm.app.farm_management.domain.location.LocationFactory;
import org.litefarm.app.farm_management.domain.location.LocationType;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class FarmTest {
    private UUID uuid;
    private String name;
    private String phoneNumber;
    private List<Location> locationList;
    private String address;
    private String units;
    private String currency;
    private String image;


    @BeforeEach
    public void init() {
        this.uuid = UUID.randomUUID();
        this.name = "San Miguel Farm";
        this.phoneNumber = "+598 12345678";
        Location location = LocationFactory.createLocation(LocationType.RESIDENCE);
        //location.setName("Test location - Residence");
        //location.setNote("No long note");
        //location.setCoordinate();
        //this.locationList = List.of(new Location(), new Location(), new Location());
        this.address = "Montemorelos, Pilares, 65515 Los Pilares, N.L., Mexico";
        this.units = "meters";
        this.currency = "USD";
        this.image = "http://s3.com/123j12";

    }

    @Test
    void givenFarmWithValidProps_whenAttemptingToCreateFarm_thenFarmIsCreated() {
        Farm farm = new Farm.Builder()
                .uuid(this.uuid)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                //.location(this.locationList)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();

        assertNotNull(farm);
    }

    @Test
    void givenFarmWithNoName_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    //.name(this.name)
                    .phoneNumber(this.phoneNumber)
                    //.location(this.locationList)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoPhoneNumber_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    //.phoneNumber(this.phoneNumber)
                    //.location(this.locationList)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoLocation_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    //.location(this.location)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoAddress_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    //.location(this.locationList)
                    //.address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoUnits_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    //.location(this.locationList)
                    .address(this.address)
                    //.units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoCurrency_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    //.location(this.locationList)
                    .address(this.address)
                    .units(this.units)
                    //.currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoImage_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    //.location(this.locationList)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    //.image(this.image)
                    .build();
        });
    }
}
