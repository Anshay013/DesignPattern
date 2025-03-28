package decorator.pizza;

import decorator.BasePizza;

public class FarmHouse extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }
}
