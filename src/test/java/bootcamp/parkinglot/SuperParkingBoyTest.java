package bootcamp.parkinglot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SuperParkingBoyTest {
    @Test
    public void should_return_a_ticket_when_first_parking_lot_is_50_percent_and_second_parking_lot_is_100_percent() {
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(2), new ParkingLot(2)));

        Token firstToken = superParkingBoy.park(new Car());
        assertNotNull(firstToken);
        assertEquals(1, firstToken.getLotId().intValue());

        Token secondToken = superParkingBoy.park(new Car());
        assertNotNull(secondToken);
        assertEquals(2, secondToken.getLotId().intValue());
    }

    @Test
    public void should_return_a_ticket_when_first_parking_lot_is_50_percent_and_second_parking_lot_is_50_percent() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        superParkingBoy.park(new Car());
        superParkingBoy.park(new Car());
        Token token = superParkingBoy.park(new Car());

        assertNotNull(token);
        assertEquals(1, token.getLotId().intValue());


    }

    @Test
    public void should_return_a_ticket_with_first_parking_lot_when_take_a_car_before_park_a_car_with_same_free_space_rete() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        Token firstToken = superParkingBoy.park(new Car());
        superParkingBoy.take(firstToken);
        Token secondToken = superParkingBoy.park(new Car());

        assertNotNull(secondToken);
        assertEquals(1, secondToken.getLotId().intValue());
    }
}
