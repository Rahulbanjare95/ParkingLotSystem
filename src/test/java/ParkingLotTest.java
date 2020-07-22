import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    Object vehicle = null;
    ParkingLot parkingLot = null;

    @Before
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingLot = new ParkingLot();
    }

    @Test
    public void givenAVehicle_whenParked_ShouldReturnTrue() {
        ParkingLot parkingLot = new ParkingLot();
        try {
            parkingLot.park(vehicle);
            boolean isParked = parkingLot.isVehicleParked(vehicle);
            Assert.assertTrue(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_whenAlreadyParked_ShouldReturnFalse() {
        try {
            parkingLot.park(vehicle);
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.FULL,e.type);
        }

    }

    @Test
    public void givenAVehicle_whenUnParked_ShouldReturnTrue() {
        try {
            parkingLot.park(vehicle);
            boolean isUnParked = parkingLot.unPark(vehicle);
            Assert.assertTrue(isUnParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicle_whenUnParkedAlready_ShouldReturnException() {
        try {
            parkingLot.park(vehicle);
            parkingLot.unPark(vehicle);
            boolean isUnParked = parkingLot.unPark(vehicle);
            Assert.assertFalse(isUnParked);
        } catch (ParkingLotException | NullPointerException e) {
            e.printStackTrace();

        }

    }

    @Test
    public void givenNull_whenUnParked_ShouldReturnFalse() {
        try {
            parkingLot.park(null);
            boolean isUnParked = parkingLot.unPark(null);
            Assert.assertFalse(isUnParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicle_whenParkingLotFull_shouldInformOwner() {
        Owner owner = new Owner();
        parkingLot.registerOwner(owner);

    }
}