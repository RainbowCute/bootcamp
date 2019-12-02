package bootcamp.parkinglot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void should_return_a_car_when_take_a_car_by_valid_token() {
        Car car = new Car("京A12345");
        ParkingLot firstParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(1, firstParkingLot);

        Token token = smartParkingBoy.park(car);
        Car carByTake = smartParkingBoy.take(token);

        assertEquals(car, carByTake);
    }

    @Test(expected = TakingFailException.class)
    public void should_return_a_message_when_tack_a_car_by_invalid_token() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(1, firstParkingLot);

        smartParkingBoy.take(new Token(1));
    }

    @Test(expected = TakingFailException.class)
    public void should_return_a_message_when_smart_boy_not_have_parking_lot() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(0, new ParkingLot(2));

        smartParkingBoy.take(new Token(1));
    }
}
