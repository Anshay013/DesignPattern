package abstractfactory;

import abstractfactory.carfactory.LuxuryFactory;
import abstractfactory.carfactory.OrdinaryFactory;
import abstractfactory.cars.BMW;
import abstractfactory.cars.Hyundai;
import abstractfactory.cars.Mercedes;
import abstractfactory.cars.Suzuki;

public class VehcileFactory {

    private VehcileAbstractFactory objCar;

    public void setVehcile(String input){

         switch (input){
            case "Mercedes" -> objCar = new LuxuryFactory(new Mercedes()); // 1
            case "BMW" -> objCar = new LuxuryFactory(new BMW());
            case "Hyundai" -> objCar = new OrdinaryFactory(new Hyundai());
            case "Suzuki" -> objCar = new OrdinaryFactory(new Suzuki());
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public int getPrice(){
        return objCar.getPrice();
    }

}
