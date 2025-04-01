package factory;

import factory.veyron.Veyron;
import factory.veyron.VeyronBase;
import factory.veyron.VeyronHigh;
import factory.veyron.VeyronMid;
import org.jetbrains.annotations.NotNull;

public class VeyronFactory {

    public Veyron getModel(@NotNull String input){

        return switch (input) {
            case "BASE" -> new VeyronBase();
            case "MID" -> new VeyronMid();
            case "HIGH" -> new VeyronHigh();
            default -> null;
        };
    }
}
