import decorator.BasePizza;
import decorator.extra.ExtraCheese;
import decorator.extra.ExtraMushroom;
import decorator.pizza.FarmHouse;
import factory.VeyronFactory;
import factory.veyron.Veyron;
import observer.observable.IphoneObservableImpl;
import observer.observable.StockObservable;
import observer.observer.EmailAlertObserver;
import observer.observer.MobileAlertObserver;
import observer.observer.NotificationAlertObserver;
import stratergy.NormalDriveStratergy;
import stratergy.OffRoadDriveStratergy;
import stratergy.SportsDriveStratergy;
import stratergy.VehcileStratergy;
import stratergy.VehcileType.NormalVehcile;
import stratergy.VehcileType.OffRoadVehcile;
import stratergy.VehcileType.SportsVehcile;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Liskov

/*        List<VehcileLiskov>list = new ArrayList<>();

        list.add(new Car());
        list.add(new MotoCycle());

        for(VehcileLiskov v : list){
            System.out.println(v.getName() + " " + v.getCost());*/
            // cannot call
            // v.getCarInsuranceNumber(), cannot call fun declared in child with a parent object but can do vice versa


       // }




        // stratergy


/*        VehcileStratergy normalVehcile = new VehcileStratergy(new NormalDriveStratergy());
        normalVehcile.drive();

        VehcileStratergy sportsVehcile = new VehcileStratergy(new SportsDriveStratergy());
        sportsVehcile.drive();

        VehcileStratergy offRoadVehcile = new VehcileStratergy(new OffRoadDriveStratergy());
        offRoadVehcile.drive();*/

        // OR we can do like this, this way we increase readability of code by making object of child classes

/*        NormalVehcile normalVehcile = new NormalVehcile(new NormalDriveStratergy());
        normalVehcile.drive();

        VehcileStratergy sportsVehcile = new SportsVehcile(new SportsDriveStratergy());
        sportsVehcile.drive();

        VehcileStratergy offRoadVehcile = new OffRoadVehcile(new OffRoadDriveStratergy());
        offRoadVehcile.drive();*/






        // Observer

/*        StockObservable iphoneObservable = new IphoneObservableImpl();


        // only for alert and send mail
        NotificationAlertObserver mobileObserver = new MobileAlertObserver("23423423", iphoneObservable);
        NotificationAlertObserver emailObserver1 = new EmailAlertObserver("fiasjfi@gmail.com", iphoneObservable);
        NotificationAlertObserver emailObserver2 = new EmailAlertObserver("dgbdsjg@gmail.com", iphoneObservable);

        // iphone is getting observed by 3 observers
        iphoneObservable.add(mobileObserver);
        iphoneObservable.add(emailObserver1);
        iphoneObservable.add(emailObserver2);

        iphoneObservable.setStockCount(10);*/


          // Decorator


/*        // I want to decorate the topping for FarmHouse
        ExtraCheese extraCheeseFarmHousePizza = new ExtraCheese(new FarmHouse());

        int cost = extraCheeseFarmHousePizza.cost();

        // now add Extra mushroom on top of extra cheese
        ExtraMushroom extraMushroomPizza = new ExtraMushroom(extraCheeseFarmHousePizza);
        System.out.println(extraMushroomPizza.cost());

        // ExtraMushroom has BasePizza as an argument, but can take ExtraCheese as a constructor argument because ExtraCheese extends ToppingDecorator and
        // ToppingDecorator extends basePizza (so it works)*/



        // factory and abstract factory

        VeyronFactory factory = new VeyronFactory();
        Veyron veyron = factory.getModel("MID");
        System.out.println("veyron price is " + veyron.getPrice());

        Veyron veyron1 = factory.getModel("HIGH");
        System.out.println("veyron price is " + veyron1.getPrice());







    }
}