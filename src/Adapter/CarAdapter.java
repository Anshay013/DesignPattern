package Adapter;

import Adapter.legacycode.Audi;
import Adapter.legacycode.Car;

public class CarAdapter implements Car {

    private final Audi audi;

    public CarAdapter(){ // note MyAudi just has this adapter and its function access. and we need to make it
                         // compatible with Audi
        audi = new Audi();

    }
    @Override
    public void startEngine() {
         audi.startEngine();
    }

    @Override
    public void getPrice() {
        audi.getPrice();
    }
}
