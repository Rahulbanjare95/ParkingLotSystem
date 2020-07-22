import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParkingLotTest {

    Object vehicle = null;
    ParkingLot parkingLot = null;


    @Before
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingLot = new ParkingLot(1);
    }

    @Test
    public void givenAVehicle_whenParked_ShouldReturnTrue() {
        ParkingLot parkingLot = new ParkingLot(1);
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
    public void givenCapacityMaxOfTwo_shouldBeAbleToPark() {
        Object vehicle2 = new Object();
        parkingLot.setCapacity(2);
        try {
            parkingLot.park(vehicle);
            parkingLot.park(vehicle2);
            boolean isParked1 = parkingLot.isVehicleParked(vehicle);
            boolean isParked2 = parkingLot.isVehicleParked(vehicle2);
            Assert.assertTrue(isParked1 && isParked2);
        } catch (ParkingLotException e) {
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
        try {
            parkingLot.park(vehicle);
            parkingLot.park(new Object());

        } catch (ParkingLotException e) {
            boolean capacityFull = owner.isCapacityFull();
            Assert.assertTrue(capacityFull);
        }
    }

}