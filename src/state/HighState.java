package state;

public class HighState implements FanState {
    @Override
    public void handlePress(Fan fan) {
        System.out.println("Fan turned OFF.");
        fan.setState(new OffState());
    }
}
