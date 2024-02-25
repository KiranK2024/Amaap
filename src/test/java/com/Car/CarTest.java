package com.Car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void shouldCreateCarWithEmptyFuelTankAndGivenFuelCapacityAndAverage(){
        Car myCar = new Car(30, 12);
        assertEquals(30, myCar.getFuelCapacity());
        assertEquals(12, myCar.getAverage());
        assertEquals(0, myCar.getDistanceToEmpty());
        assertEquals(0, myCar.getDistanceTravelled());
        assertEquals(0, myCar.getAvailableFuel());
    }

    @Test
    void shouldBeAbleToRefuelCar() throws Exception {
        Car myCar = new Car(30, 12);
        myCar.reFuel(21);
        assertEquals(21, myCar.getAvailableFuel());
        assertEquals(252, myCar.getDistanceToEmpty());
    }

    @Test
    void shouldNotOverFuelCar() {
        Car myCar = new Car(30, 12);

        assertThrows(Exception.class, ()->{myCar.reFuel(36);});
        assertEquals(0, myCar.getAvailableFuel());
        assertEquals(0, myCar.getDistanceToEmpty());
    }

    @Test
    void shouldConsumeFuelWhenGivenDistanceTravelled()throws Exception{
        //Arrange
        Car myCar = new Car(30, 12);
        myCar.reFuel(21);

        assertEquals(21, myCar.getAvailableFuel());
        assertEquals(252, myCar.getDistanceToEmpty());

        int iDistanceToBeTravelled = 36;
        myCar.travel(iDistanceToBeTravelled);

        assertEquals(18, myCar.getAvailableFuel());
        assertEquals(216, myCar.getDistanceToEmpty());
    }

    @Test
    void shouldWarnUserWhenGivenDistanceToTravelIsMoreThanDistanceToEmpty()throws Exception{
        //Arrange
        Car myCar = new Car(30, 12);
        myCar.reFuel(21);

        assertEquals(21, myCar.getAvailableFuel());
        assertEquals(252, myCar.getDistanceToEmpty());

        //Open Questions: Is it possible to throw warning message (not error exception message) in unit test
        assertThrows(Exception.class, ()->{myCar.travel(300);});
    }

}
