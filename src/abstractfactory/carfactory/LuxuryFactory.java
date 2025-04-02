package abstractfactory.carfactory;

import abstractfactory.VehcileAbstractFactory;
import abstractfactory.cars.VehcileCar;

public class LuxuryFactory implements VehcileAbstractFactory {

    private final VehcileCar car;
    public LuxuryFactory(VehcileCar car){
        this.car = car;
    }


    @Override
    public int getPrice() {
        return car.getPrice();
    }
}
