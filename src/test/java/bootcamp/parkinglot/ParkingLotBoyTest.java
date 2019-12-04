package bootcamp.parkinglot;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class ParkingLotBoyTest {

    private static final int PARKING_LOT_NUM = 2;
    private static final int PARKING_LOT_CAPACITY = 2;

    @Test
    public void should_park_success_when_capacity_is_not_full() {
        ParkingBoy parkingLotBoy = new ParkingBoy(ParkingLotFactory.create(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        Token token = parkingLotBoy.park(new Car());
        assertNotNull(token);
    }

    @Test
    public void should_take_success_when_token_is_valid() {
        ParkingBoy parkingLotBoy = new ParkingBoy(ParkingLotFactory.create(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        Token token = parkingLotBoy.park(new Car());
        Car car = parkingLotBoy.take(token);
        assertNotNull(car);
    }

    @Test(expected= TakingFailException.class)
    public void should_take_fail_when_token_is_invalid() {
        ParkingBoy parkingLotBoy = new ParkingBoy(ParkingLotFactory.create(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        parkingLotBoy.park(new Car());
        parkingLotBoy.take(new Token());
    }

    @Test(expected= TakingFailException.class)
    public void should_take_fail_when_multi_take() {
        ParkingBoy parkingLotBoy = new ParkingBoy(ParkingLotFactory.create(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        Token token = parkingLotBoy.park(new Car());
        Car car = parkingLotBoy.take(token);
        assertNotNull(car);
        parkingLotBoy.take(token);
    }
}