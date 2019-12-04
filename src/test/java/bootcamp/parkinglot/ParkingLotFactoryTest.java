package bootcamp.parkinglot;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotFactoryTest {

    private static final int PARKING_LOT_NUM = 2;
    private static final int PARKING_LOT_CAPACITY = 2;

    @Test
    public void should_return_parking_lots_given_sizes() {
        List<ParkingLot> parkingLots = ParkingLotFactory.create(PARKING_LOT_NUM, PARKING_LOT_CAPACITY);
        assertNotNull(parkingLots);
        assertEquals(2, parkingLots.size());
    }
}