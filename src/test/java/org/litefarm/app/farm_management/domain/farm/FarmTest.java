package org.litefarm.app.farm_management.domain.farm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.litefarm.app.farm_management.domain.Unit;
import org.litefarm.app.farm_management.domain.coordinate.Coordinate;
import org.litefarm.app.farm_management.domain.coordinate.CoordinateArea;
import org.litefarm.app.farm_management.domain.exception.BusinessRuleException;
import org.litefarm.app.farm_management.domain.location.LocationType;
import org.litefarm.app.farm_management.domain.location.Residence;
import org.litefarm.app.farm_management.domain.location.ResidenceIngressData;
import org.litefarm.app.farm_management.domain.location.TotalArea;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class FarmTest {
    private FarmId farmId;
    private String name;
    private String phoneNumber;
    private String address;
    private String units;
    private String currency;
    private String image;
    private ArrayList<UUID> locationUUIDs;
    private ResidenceIngressData residenceIngressData;


    @BeforeEach
    public void init() {
        this.farmId = new FarmId(UUID.randomUUID());

        this.name = "San Miguel Farm";
        this.phoneNumber = "+598 12345678";
        this.residenceIngressData = new ResidenceIngressData(
                UUID.randomUUID(),
                "Residencia Trevino",
                "Long note in here, lotem ipsum dolorum",
                new CoordinateArea(List.of(
                        new Coordinate(70.23, 83.3),
                        new Coordinate(70.25, 83.3),
                        new Coordinate(70.26, 83.3))),
                new TotalArea(123.4, Unit.SQUARE_METERS),
                LocationType.RESIDENCE
        );
        var residence = Residence.of(residenceIngressData);
        this.locationUUIDs = new ArrayList<>(List.of(residence.getLocationUUID()));

        this.address = "Montemorelos, Pilares, 65515 Los Pilares, N.L., Mexico";
        this.units = "meters";
        this.currency = "USD";
        this.image = "http://s3.com/123j12";
    }

    @Test
    void givenFarmWithInitialState_whenLocationIsNotExistent_thenFarmIsCreated() {
        Farm farm = new Farm.Builder()
                .farmId(this.farmId)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .locations(null)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();

        assertNotNull(farm);
        assertNotNull(farm.getLocations());

    }

    @Test
    void givenFarmWithInitialState_whenLocationsAreSet_thenFarmIsCreated() {
        Farm farm = new Farm.Builder()
                .farmId(this.farmId)
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
    void givenFarmWithNoName_whenAttemptingToCreateFarm_thenBusinessRuleExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .farmId(this.farmId)
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
    void givenFarmWithNoPhoneNumber_whenAttemptingToCreateFarm_thenBusinessRuleExceptionIsThrown() {
        assertThrows(BusinessRuleException.class, () -> {
            new Farm.Builder()
                    .farmId(this.farmId)
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
                    .farmId(this.farmId)
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
                    .farmId(this.farmId)
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
                    .farmId(this.farmId)
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
                    .farmId(this.farmId)
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

    @Test
    void givenLocationIsNeeded_whenCallingCreateLocation_thenFarmGetsUpdatesWithNewLocation() {
        var farm = new Farm.Builder()
                .farmId(this.farmId)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();


        var location = farm.createLocation(this.residenceIngressData);
        Assertions.assertEquals(location.getLocationUUID(), farm.getLocations().get(0));
    }

    @Test
    void givenANewFarm_whenAddingMultipleLocations_thenFarmGetsUpdatesWithAllLocationIDs() {
        var farm = new Farm.Builder()
                .farmId(this.farmId)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();


        var location = farm.createLocation(this.residenceIngressData);

        var rid2 = new ResidenceIngressData(
                UUID.randomUUID(),
                "Test House",
                "Long note in here, lotem ipsum dolorum",
                new CoordinateArea(List.of(
                        new Coordinate(70.23, 83.3),
                        new Coordinate(70.25, 83.3),
                        new Coordinate(70.26, 83.3))),
                new TotalArea(123.4, Unit.SQUARE_METERS),
                LocationType.RESIDENCE
        );

        var location2 = farm.createLocation(rid2);

        var rid3 = new ResidenceIngressData(
                UUID.randomUUID(),
                "Test House3",
                "Long note in here, lotem ipsum dolorum",
                new CoordinateArea(List.of(
                        new Coordinate(70.23, 83.3),
                        new Coordinate(70.25, 83.3),
                        new Coordinate(70.26, 83.3))),
                new TotalArea(123.4, Unit.SQUARE_METERS),
                LocationType.RESIDENCE
        );
        var location3 = farm.createLocation(rid3);
        Assertions.assertEquals(location.getLocationUUID(), farm.getLocations().get(0));
        Assertions.assertEquals(location2.getLocationUUID(), farm.getLocations().get(1));
        Assertions.assertEquals(location3.getLocationUUID(), farm.getLocations().get(2));
    }


    @Test
    void givenANewFarm_whenUpdatingALocation_thenFarmGetsUpdatesWithAllLocationIDs() {
        var farm = new Farm.Builder()
                .farmId(this.farmId)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .units(this.units)
                .currency(this.currency)
                .image(this.image)
                .build();


        var location = farm.createLocation(this.residenceIngressData);

        var rid2 = new ResidenceIngressData(
                UUID.randomUUID(),
                "Test House",
                "Long note in here, lotem ipsum dolorum",
                new CoordinateArea(List.of(
                        new Coordinate(70.23, 83.3),
                        new Coordinate(70.25, 83.3),
                        new Coordinate(70.26, 83.3))),
                new TotalArea(123.4, Unit.SQUARE_METERS),
                LocationType.RESIDENCE
        );

        var location2 = farm.createLocation(rid2);

        var rid3 = new ResidenceIngressData(
                UUID.randomUUID(),
                "Test House3",
                "Long note in here, lotem ipsum dolorum",
                new CoordinateArea(List.of(
                        new Coordinate(70.23, 83.3),
                        new Coordinate(70.25, 83.3),
                        new Coordinate(70.26, 83.3))),
                new TotalArea(123.4, Unit.SQUARE_METERS),
                LocationType.RESIDENCE
        );
        var location3 = farm.createLocation(rid3);
        Assertions.assertEquals(location.getLocationUUID(), farm.getLocations().get(0));
        Assertions.assertEquals(location2.getLocationUUID(), farm.getLocations().get(1));
        Assertions.assertEquals(location3.getLocationUUID(), farm.getLocations().get(2));
    }
}

