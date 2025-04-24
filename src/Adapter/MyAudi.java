package Adapter;

import Adapter.legacycode.Car;

public class MyAudi implements Car {

    private CarAdapter carAdapter;

    public MyAudi(CarAdapter carAdapter){
        this.carAdapter = carAdapter;
    }


    @Override
    public void startEngine() {
        // we cannot start engine since its not compatible with car even if we extend MyAudi with car.
        // so how to do it ?. Make Adapter object call it, which will further call the Audi car which
        // is compatible
        carAdapter.startEngine();

    }

    @Override
    public void getPrice() {
        carAdapter.getPrice();
    }
}
