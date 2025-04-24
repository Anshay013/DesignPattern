package Adapter.legacycode;

public class Audi implements Car {

    @Override
    public void startEngine() {
        System.out.println("Audi engine started");
    }

    @Override
    public void getPrice() {
        System.out.println("Audi price is : $999999");
    }
}
