package bootcamp.parkinglot;

import bootcamp.parkinglot.boy.SmartParkingBoy;
import bootcamp.parkinglot.boy.SuperParkingBoy;
import bootcamp.parkinglot.exception.TakingFailException;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingManagerTest {
    @Test
    public void should_return_a_ticket_when_manager_has_a_boy_with_free_space() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(2)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        Car carByTake = superParkingBoy.take(token);
        assertEquals(car, carByTake);
    }

    @Test
    public void should_return_a_ticket_when_manager_has_a_boy_no_free_space_and_manager_has_free_space() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(0)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        Car carByTake = parkingManager.take(token);
        assertEquals(car, carByTake);
    }

    @Test
    public void should_return_a_ticket_when_manager_has_two_boys_have_free_space_and_manager_has_free_space() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingManager.hire(smartParkingBoy);
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        Car carByTake = smartParkingBoy.take(token);
        assertEquals(carByTake, car);
    }

    @Test
    public void should_return_a_ticket_when_manager_has_one_boy_has_free_space_and_two_boy_has_no_free_space() {
        ParkingManager parkingManager = new ParkingManager(Collections.singletonList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(0)));
        parkingManager.hire(smartParkingBoy);
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        Car carByTake = superParkingBoy.take(token);
        assertEquals(carByTake, car);
    }

    @Test
    public void should_return_a_ticket_when_manager_has_two_same_boys_has_free_space() {
        ParkingManager parkingManager = new ParkingManager(Collections.singletonList(new ParkingLot(1)));
        SuperParkingBoy firstSuperParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy secondSuperParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingManager.hire(secondSuperParkingBoy);
        parkingManager.hire(firstSuperParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        Car carByTake = secondSuperParkingBoy.take(token);
        assertEquals(carByTake, car);
    }

    @Test(expected = TakingFailException.class)
    public void should_throw_parkingFailException_when_manager_has_a_boy_no_free_space_and_manager_has_free_space() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(0)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        superParkingBoy.take(token);
    }

    @Test
    public void should_return_a_car_when_manager_take_a_car_with_valid_token() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        assertNotNull(token);

        Car carByTake = parkingManager.take(token);

        assertEquals(car, carByTake);
    }

    @Test(expected = TakingFailException.class)
    public void should_throw_exception_when_take_fail_with_invalid_token() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        parkingManager.park(car);

        parkingManager.take(new Token());
    }

    @Test(expected = TakingFailException.class)
    public void should_throw_exception_when_take_fail_with_null_token() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        parkingManager.park(car);

        parkingManager.take(null);
    }

    @Test(expected = TakingFailException.class)
    public void should_throw_exception_when_take_fail_with_multi_take() {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingManager.hire(superParkingBoy);

        Car car = new Car();
        Token token = parkingManager.park(car);

        Car carByTake = parkingManager.take(token);
        assertEquals(car, carByTake);

        parkingManager.take(token);
    }
}
