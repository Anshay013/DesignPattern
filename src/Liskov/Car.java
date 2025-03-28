package Liskov;

public class Car implements VehcileLiskov {
    @Override
    public String getName() {
        return "Liskov.Car";
    }

    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public int getCost() {
        return 100;
    }

    public int getCarInsuranceNumber(){
        return 2344234;
    }
}
