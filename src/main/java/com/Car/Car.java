package com.Car;

public class Car {
    private int average;
    private int fuelCapacity;
    private int distanceTravelled;
    private int availableFuel;
    public Car(int iiFuelCapacity, int iiAverage){
        this.average = iiAverage;
        this.fuelCapacity = iiFuelCapacity;
        distanceTravelled = 0;
        availableFuel = 0;
    }

    public int getAverage() {
        return average;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getDistanceToEmpty() {
        return average*availableFuel;
    }


    public int getAvailableFuel() {
        return availableFuel;
    }
    public void reFuel(int iiFuelAdded) throws Exception {
        validateRefuelling(iiFuelAdded);
        availableFuel +=  iiFuelAdded;
    }

    private void validateRefuelling(int iiFuelAdded) throws Exception {
        if( (availableFuel+iiFuelAdded) > fuelCapacity )
            throw new Exception();
    }

    public void travel(int iiDistanceToBeTravelled) throws Exception {
        int fuelConsumed = iiDistanceToBeTravelled / average;
        if (fuelConsumed > availableFuel) {
            fuelConsumed = availableFuel;
            iiDistanceToBeTravelled = availableFuel * average;
        }
        availableFuel = availableFuel - fuelConsumed;

        distanceTravelled = distanceTravelled + iiDistanceToBeTravelled;

        if (0 == availableFuel) {
            throw new Exception();
        }
    }
}
