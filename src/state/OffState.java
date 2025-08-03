package state;

public class OffState implements FanState {
    @Override
    public void handlePress(Fan fan) {
        System.out.println("Fan turned to LOW speed.");
        fan.setState(new LowState());
    }
}

