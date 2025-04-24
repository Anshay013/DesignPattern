package proxy;

import Adapter.legacycode.Car;

public class RealCar implements Car {


    @Override
    public void startEngine() {
     System.out.println("engine started");
    }

    @Override
    public void getPrice() {
        System.out.println("the price is $100000");
    }
}
