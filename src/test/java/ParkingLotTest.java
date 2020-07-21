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
        boolean isParked = parkingLot.park(new Object());
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenAVehicle_whenAlreadyParked_ShouldReturnFalse() {
        parkingLot.park(vehicle);
        boolean isParked = parkingLot.park(vehicle);
        Assert.assertFalse(isParked);
    }

    @Test
    public void givenNull_whenParked_ShouldReturnFalse() {
        parkingLot.park(vehicle);
        boolean isParked = parkingLot.park(null);
        Assert.assertFalse(isParked);

    }
}