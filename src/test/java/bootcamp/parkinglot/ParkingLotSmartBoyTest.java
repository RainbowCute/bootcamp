package bootcamp.parkinglot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotSmartBoyTest {
    @Test
    public void should_return_a_ticket_with_second_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        smartParkingBoy.addParkingLot(1, firstParkingLot);
        smartParkingBoy.addParkingLot(2, secondParkingLot);
        Token token = smartParkingBoy.park(new Car());

        assertEquals(2, token.getLotId().intValue());
    }

    @Test
    public void should_return_a_ticket_with_first_parking_lot_when_same_free_space() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        smartParkingBoy.addParkingLot(1, firstParkingLot);
        smartParkingBoy.addParkingLot(2, secondParkingLot);
        Token token = smartParkingBoy.park(new Car());

        assertEquals(1, token.getLotId().intValue());
    }

    @Test
    public void should_return_a_ticket_with_first_parking_lot_when_first_parking_lot_free_one_then_take_a_car_and_second_parking_lot_free_two() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        smartParkingBoy.addParkingLot(1, firstParkingLot);
        smartParkingBoy.addParkingLot(2, secondParkingLot);
        Token token = smartParkingBoy.park(new Car());
        smartParkingBoy.take(token);

        Token token1 = smartParkingBoy.park(new Car());

        assertEquals(1, token1.getLotId().intValue());
    }

    @Test
    public void should_return_a_ticket_with_first_parking_lot_when_have_one_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        smartParkingBoy.addParkingLot(1, firstParkingLot);
        Token token = smartParkingBoy.park(new Car());

        assertEquals(1, token.getLotId().intValue());
    }

    @Test
    public void should_return_a_car_when_take_a_car_by_token() {
        Car car = new Car("京A12345");
        ParkingLot firstParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(1, firstParkingLot);

        Token token = smartParkingBoy.park(car);
        Car carByTake = smartParkingBoy.take(token);

        assertEquals(car, carByTake);
    }
}
