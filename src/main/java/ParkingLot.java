import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class ParkingLot {
    private int originalCapacity;
    public Object vehicle;
    private Owner owner;
    private int currentCapacity;

    List vehicles;
    public ParkingLot(int capacity) {
        this.originalCapacity = capacity;
        this.vehicles = new ArrayList();
    }

    public void park(Object vehicle) throws ParkingLotException {
        if( this.vehicles.size() > this.originalCapacity ) {
            owner.parkingLotFull();
            throw new ParkingLotException("Parking Full",
                    ParkingLotException.ExceptionType.FULL);
        }
        if (this.isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle Already Parked", ParkingLotException.ExceptionType.ALREADY_PARKED);
        this.vehicles.add(vehicle);
    }
    public boolean isVehicleParked(Object vehicle) {
        if(this.vehicles.contains(vehicle))
            return true;
        return false;
    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if(this.vehicle == null) return  false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            return true;
        }
        throw new ParkingLotException("No such model exist", ParkingLotException.ExceptionType.WRONG_DETAILS);
    }

    public void registerOwner(Owner owner) {
        this.owner = owner;
    }

    public void setCapacity(int capacity) {
        this.originalCapacity = capacity;
    }
}
