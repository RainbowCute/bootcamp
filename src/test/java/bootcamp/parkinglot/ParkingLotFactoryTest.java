package bootcamp.parkinglot;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ParkingLotFactoryTest {

    private static final int PARKING_LOT_NUM = 2;
    private static final int PARKING_LOT_CAPACITY = 2;

    @Test
    public void should_return_parking_lots_given_sizes() {
        Map<Integer, ParkingLot> lotIdParkingLotMap = ParkingLotFactory.create(PARKING_LOT_NUM, PARKING_LOT_CAPACITY);
        assertNotNull(lotIdParkingLotMap);
        assertEquals(2, lotIdParkingLotMap.size());
    }
}