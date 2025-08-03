package state;

public class LowState implements FanState {
    @Override
    public void handlePress(Fan fan) {
        System.out.println("Fan turned to HIGH speed.");
        fan.setState(new HighState());
    }
}

