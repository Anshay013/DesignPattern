package abstractfactory.carfactory;

import abstractfactory.VehcileAbstractFactory;
import abstractfactory.cars.VehcileCar;

public class OrdinaryFactory implements VehcileAbstractFactory {

    private final VehcileCar car;
    public OrdinaryFactory(VehcileCar car){
        this.car = car;
    }

    @Override
    public int getPrice() {
        return car.getPrice();
    }

}
