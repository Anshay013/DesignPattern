package proxy;

import Adapter.legacycode.Car;

public class ProxyCar implements Car {

    private RealCar car;

    public ProxyCar(RealCar car){
        this.car = car;
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public void getPrice() {
         car.getPrice();
    }
}
