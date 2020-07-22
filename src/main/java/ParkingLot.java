
public class ParkingLot {
    public Object vehicle;
    private Owner owner;

    public ParkingLot() {
    }

    public void park(Object vehicle) throws ParkingLotException {
        if( this.vehicle != null )
            throw  new ParkingLotException("Parking Full",
                    ParkingLotException.ExceptionType.FULL);
        this.vehicle = vehicle;
    }
    public boolean isVehicleParked(Object vehicle) {
        if(this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if(this.vehicle == null) return  false;
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        throw new ParkingLotException("No such model exist", ParkingLotException.ExceptionType.WRONG_DETAILS);
    }


    public boolean registerOwner(Owner owner) {
        this.owner = owner;
        return  true;
    }

}
