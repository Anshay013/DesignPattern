package decorator.pizza;

import decorator.BasePizza;

public class margherita extends BasePizza {
    @Override
    public int cost() {
        return 150;
    }
}
