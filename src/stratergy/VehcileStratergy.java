package stratergy;

public class VehcileStratergy {

    private final DriveStratergy driveStratergy;

    public VehcileStratergy(DriveStratergy driveStratergy){
        this.driveStratergy = driveStratergy;
    }

    public void drive(){
        driveStratergy.drive();
    }
}
