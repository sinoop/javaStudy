package model.parkinglot;

import model.parkinglot.vehicle.Car;
import model.parkinglot.vehicle.VehicleSize;

public class ParkingSlot {
    private int floor;
    private String spotNumber;
    private boolean isOccupied;
    private Car ocupiedBy;
    private VehicleSize spotSize;

    public boolean isOccupied() {
        return isOccupied;
    }

    public Car getOcupiedBy() {
        return ocupiedBy;
    }

    public int getFloor() {
        return floor;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }


}
