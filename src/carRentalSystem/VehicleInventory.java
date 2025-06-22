package carRentalSystem;

import carRentalSystem.model.RentCar;

import java.util.List;

public class VehicleInventory {

    public List<RentCar> getCarList() {
        return carList;
    }

    public void setCarList(List<RentCar> carList) {
        this.carList = carList;
    }

    private List<RentCar>carList;

}
