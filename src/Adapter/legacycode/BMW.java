package Adapter.legacycode;

public class BMW implements Car {

    @Override
    public void startEngine() {
        System.out.println("BMW engine started");
    }

    @Override
    public void getPrice() {
       System.out.println("BMW price is : $999999");
    }
}
