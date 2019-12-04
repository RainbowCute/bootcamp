package bootcamp.parkinglot;

import bootcamp.parkinglot.exception.ParkingFailException;
import bootcamp.parkinglot.exception.TakingFailException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ParkingLotTest {

    @Test
    public void should_park_success_when_capacity_is_not_full() {
        Token token = new ParkingLot(2).park(new Car());
        assertNotNull(token);
    }

    @Test(expected= ParkingFailException.class)
    public void should_throw_park_fail_exception_when_capacity_is_full() {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
    }

    @Test
    public void should_take_success_when_token_is_valid() {
        ParkingLot parkingLot = new ParkingLot(3);
        Token token = parkingLot.park(new Car());
        Car car = parkingLot.take(token);
        assertNotNull(car);
    }

    @Test(expected= TakingFailException.class)
    public void should_take_fail_when_token_is_invalid() {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());
        parkingLot.take(new Token());
    }

    @Test(expected= TakingFailException.class)
    public void should_take_fail_when_multi_take() {
        ParkingLot parkingLot = new ParkingLot(3);
        Token token = parkingLot.park(new Car());
        Car car = parkingLot.take(token);
        assertNotNull(car);
        parkingLot.take(token);
    }
}