package decorator.extra;

import decorator.BasePizza;
import decorator.ToppingDecorator;

public class ExtraMushroom extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraMushroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 60;
    }

}
