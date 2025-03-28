package Liskov;

public class MotoCycle implements VehcileLiskov {

    public String getName() {
        return "Liskov.MotoCycle";
    }

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public int getCost() {
        return 50;
    }
}
