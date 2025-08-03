package state;

public class Fan {
    private FanState state;

    public Fan() {
        // Initial state
        state = new OffState();
    }

    public void setState(FanState state) {
        this.state = state;
    }

    public void pressButton() {
        state.handlePress(this);
    }
}

