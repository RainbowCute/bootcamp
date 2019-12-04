package bootcamp.parkinglot;

import bootcamp.parkinglot.boy.ParkingBoy;
import bootcamp.parkinglot.exception.ParkingFailException;
import bootcamp.parkinglot.exception.TakingFailException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ParkingBoyTest {

    private static final int PARKING_LOT_NUM = 2;
    private static final int PARKING_LOT_CAPACITY = 2;

    @Test
    public void should_park_success_when_capacity_is_not_full() {
        ParkingBoy parkingLotBoy = new ParkingBoy(createParkingLots(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        Token token = parkingLotBoy.park(new Car());
        assertNotNull(token);
    }

    @Test(expected = ParkingFailException.class)
    public void should_park_fail_when_capacity_is_full() {
        ParkingBoy parkingLotBoy = new ParkingBoy(createParkingLots(1, 0));
        parkingLotBoy.park(new Car());
    }

    @Test
    public void should_take_success_when_token_is_valid() {
        ParkingBoy parkingLotBoy = new ParkingBoy(createParkingLots(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        Token token = parkingLotBoy.park(new Car());
        Car car = parkingLotBoy.take(token);
        assertNotNull(car);
    }

    @Test(expected= TakingFailException.class)
    public void should_take_fail_when_token_is_invalid() {
        ParkingBoy parkingLotBoy = new ParkingBoy(createParkingLots(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        parkingLotBoy.park(new Car());
        parkingLotBoy.take(new Token());
    }

    @Test(expected= TakingFailException.class)
    public void should_take_fail_when_multi_take() {
        ParkingBoy parkingLotBoy = new ParkingBoy(createParkingLots(PARKING_LOT_NUM, PARKING_LOT_CAPACITY));
        Token token = parkingLotBoy.park(new Car());
        Car car = parkingLotBoy.take(token);
        assertNotNull(car);
        parkingLotBoy.take(token);
    }

    private List<ParkingLot> createParkingLots(int parkingLotNum, int parkingLotCapacity) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < parkingLotNum; i++) {
            parkingLots.add(new ParkingLot(parkingLotCapacity));
        }
        return parkingLots;
    }
}