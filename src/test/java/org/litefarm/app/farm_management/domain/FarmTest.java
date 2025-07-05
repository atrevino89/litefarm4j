package org.litefarm.app.farm_management.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.coordinate.Coordinate;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;
import org.litefarm.app.farm_management.domain.location.Location;
import org.litefarm.app.farm_management.domain.location.Residence;
import org.litefarm.app.farm_management.domain.location.ResidenceIngressData;
import org.litefarm.app.farm_management.domain.location.TotalArea;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class FarmTest {
    private UUID uuid;
    private String name;
    private String phoneNumber;
    private String address;
    private String units;
    private String currency;
    private String image;
    private List<UUID> locationUUIDs;


    @BeforeEach
    public void init() {
        this.uuid = UUID.randomUUID();
        this.name = "San Miguel Farm";
        this.phoneNumber = "+598 12345678";
        var residenceIngressData = new ResidenceIngressData(
                UUID.randomUUID(),
                "Residencia Trevino",
                "Long note in here, lotem ipsum dolorum",
                new CoordinateArea(List.of(
                        new Coordinate(70.23, 83.3),
                        new Coordinate(70.25, 83.3),
                        new Coordinate(70.26, 83.3))),
                new TotalArea(123.4, Unit.SQUARE_METERS)
        );
        var residence = Residence.of(residenceIngressData);
        this.locationUUIDs = List.of(residence.getLocationUUID());

        this.address = "Montemorelos, Pilares, 65515 Los Pilares, N.L., Mexico";
        this.units = "meters";
        this.currency = "USD";
        this.image = "http://s3.com/123j12";

        //this.location = LocationFactory.createLocation(LocationType.RESIDENCE);

    }

    @Test
    void givenFarmWithInitialState_whenLocationIsNotExistent_thenFarmIsCreated() {
        Farm farm = new Farm.Builder()
                .uuid(this.uuid)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .locations(null)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();

        assertNotNull(farm);
        assertNull(farm.getLocations());

    }

    @Test
    void givenFarmWithInitialState_whenLocationsAreSet_thenFarmIsCreated() {
        Farm farm = new Farm.Builder()
                .uuid(this.uuid)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .locations(this.locationUUIDs)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();

        assertEquals(locationUUIDs, farm.getLocations());
    }

    @Test
    void givenFarmWithNoName_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    //.name(this.name)
                    .phoneNumber(this.phoneNumber)
                    .locations(this.locationUUIDs)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoPhoneNumber_whenAttemptingToCreateFarm_thenIllegalArgumentExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    //.phoneNumber(this.phoneNumber)
                    .locations(this.locationUUIDs)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoAddress_whenAttemptingToCreateFarm_thenBusinessRuleExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    .locations(this.locationUUIDs)
                    //.address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoUnits_whenAttemptingToCreateFarm_thenBusinessRuleExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    .locations(this.locationUUIDs)
                    .address(this.address)
                    //.units(this.units)
                    .currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoCurrency_whenAttemptingToCreateFarm_thenBusinessRuleExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    .locations(this.locationUUIDs)
                    .address(this.address)
                    .units(this.units)
                    //.currency(this.currency)
                    .image(this.image)
                    .build();
        });
    }

    @Test
    void givenFarmWithNoImage_whenAttemptingToCreateFarm_thenBusinessRuleExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .uuid(this.uuid)
                    .name(this.name)
                    .phoneNumber(this.phoneNumber)
                    .locations(this.locationUUIDs)
                    .address(this.address)
                    .units(this.units)
                    .currency(this.currency)
                    //.image(this.image)
                    .build();
        });
    }
}
