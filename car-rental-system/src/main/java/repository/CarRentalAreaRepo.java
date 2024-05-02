package repository;

import models.CarRentalArea;

public class CarRentalAreaRepo {
    CarRentalArea carRentalArea;

    public CarRentalAreaRepo(CarRentalArea carRentalArea) {
        this.carRentalArea = carRentalArea;
    }

    public CarRentalArea getCarRentalArea() {
        return carRentalArea;
    }

    public void setCarRentalArea(CarRentalArea carRentalArea) {
        this.carRentalArea = carRentalArea;
    }
}
