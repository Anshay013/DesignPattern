import command.*;
import command.commanditem.Light;
import command.service.LightExecuterService;
import command.service.ServiceExecuter;
import streams.MobilePhone;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

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

/*        VehcileStratergy normalVehcile = new NormalVehcile(new NormalDriveStratergy());
        normalVehcile.drive();

        VehcileStratergy sportsVehcile = new SportsVehcile(new SportsDriveStratergy());
        sportsVehcile.drive();

        VehcileStratergy offRoadVehcile = new OffRoadVehcile(new OffRoadDriveStratergy());
        offRoadVehcile.drive();*/


/*        PaymentService cashService = new CashService(new PaymentCash());
        cashService.pay();

        PaymentService upiService = new UPIService(new PaymentUPI());
        upiService.pay();

        PaymentService creditCardService = new CredirCardService(new PaymentCreditCard());
        creditCardService.pay();*/











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

  /*      VeyronFactory factory = new VeyronFactory();
        Veyron veyron = factory.getModel("MID");
        System.out.println("veyron price is " + veyron.getPrice());

        Veyron veyron1 = factory.getModel("HIGH");
        System.out.println("veyron price is " + veyron1.getPrice());
*/

        // abstract factory

/*        VehcileFactory factory = new VehcileFactory();
        factory.setVehcile("Mercedes");

        System.out.println(factory.getPrice());

        factory.setVehcile("BMW");
        System.out.println(factory.getPrice());

        factory.setVehcile("Hyundai");
        System.out.println(factory.getPrice());

        factory.setVehcile("Suzuki");

        System.out.println(factory.getPrice());*/


        // ParkingLot
        // ParkingLotService -> ParkingSpotManager -> parkingSpotStratergy
/*
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(1);
        vehicle.setParked(false);
        vehicle.setVehicleNo(8323);
        vehicle.setSpot(null);



        ParkingSpotStrategy spot = new TwoWheelerSpot();

        // while spot ios assgined then, spot is modified

        ParkingLotService twoWheelerService = new TwoWheelerParkingService(new EntryGate(new TwoWheelerStrategyManager(vehicle, spot)));
        twoWheelerService.vehicleEntry();

        twoWheelerService = new TwoWheelerParkingService(new ExitGate(new TwoWheelerStrategyManager(vehicle, spot)));

        twoWheelerService.vehicleExit();
        twoWheelerService.computeCost();*/



        // Elevator System'
  /*      int currentFloor = 5;
        ElevatorService service = new ElevatorServiceImpl(new CreateServiceFactory());
        ExternalButton button = service.callElevatorService();


        button.setCurrentFloor(currentFloor);  // my current floor
        button.pressExternalButton(Direction.DOWN); // I want to go down


        System.out.println();

        // inside the elevator
        ElevatorCar car = service.reachDestinationService();
        car.clickButton(currentFloor, 10);*/


        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(3, 4));

        BiConsumer <Boolean, Integer> letsConsume = (flag, x) -> {
            System.out.println(x);
            System.out.println(flag);
        };

        BiFunction<Integer, Integer, Integer> myFun = (x, y) -> x + y;
        myFun.apply(2, 4);
        // check how to use myFun.andThen

        Function<Integer, Integer> ab = x -> x + 1;
        // instead use a uniary operator

        UnaryOperator<Integer> a = x -> x + 1; // check that Unary operator also extends a Function so

        // for BiFunction simply use BinaryOperator


        // Method reference

        List<String> students = Arrays.asList("aa", "bb", "cc");
        students.forEach(x -> System.out.println(x)); // we are doing a for loop and observe we feed x i.e students[i] sort of and print
        // i.e we feed an argument and it returns void, it's sort of a consumer

        students.forEach(System.out::println); // method reference

        // constructor reference
        List<String> names = Arrays.asList("A", "B", "C");

        List<MobilePhone> phoneList = names.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());

        // for this method or constructor reference will look like ->

        List<MobilePhone> pl = names.stream().map(MobilePhone::new).toList();



        // Command Design Pattern


        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);

        ServiceExecuter executer = new LightExecuterService(lightOnCommand);

        executer.execute();

        Command lightOffCommand = new LightOffCommand(light);
        executer = new LightExecuterService(lightOffCommand);

        executer.execute();

        Command lightChangeCommand = new LightChangeCommand(light, Color.blue);

        executer = new LightExecuterService(lightChangeCommand);

        executer.execute();

















    }


}