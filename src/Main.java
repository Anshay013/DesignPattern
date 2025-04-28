import elevator.Direction;
import elevator.ElevatorCar;
import elevator.createService.CreateServiceFactory;
import elevator.dispatcher.externalButton.ExternalButton;
import elevator.service.ElevatorService;
import elevator.service.ElevatorServiceImpl;
import parkingLot.EntryGate;
import parkingLot.ExitGate;
import parkingLot.ParkingLotService;
import parkingLot.TwoWheelerParkingService;
import parkingLot.manager.ParkingSpotManager;
import parkingLot.manager.TwoWheelerStrategyManager;
import parkingLot.model.ParkingSpot;
import parkingLot.model.Vehicle;
import parkingLot.parkingStrategy.ParkingSpotStrategy;
import parkingLot.parkingStrategy.TwoWheelerSpot;

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
        int currentFloor = 5;
        ElevatorService service = new ElevatorServiceImpl(new CreateServiceFactory());
        ExternalButton button = service.callElevatorService();


        button.setCurrentFloor(currentFloor);  // my current floor
        button.pressExternalButton(Direction.DOWN); // I want to go down


        System.out.println();

        // inside the elevator
        ElevatorCar car = service.reachDestinationService();
        car.clickButton(currentFloor, 10);





    }
}