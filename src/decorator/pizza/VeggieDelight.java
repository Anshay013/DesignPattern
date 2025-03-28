package decorator.pizza;

import decorator.BasePizza;

public class VeggieDelight extends BasePizza {
    @Override
    public int cost() {
        return 170;
    }
}
