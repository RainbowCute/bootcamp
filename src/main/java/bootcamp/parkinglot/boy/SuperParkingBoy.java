package bootcamp.parkinglot.boy;

import bootcamp.parkinglot.ParkingLot;
import bootcamp.parkinglot.boy.BaseBoy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SuperParkingBoy extends BaseBoy {

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Optional<Map.Entry<Integer, ParkingLot>> getParkingLot() {
        return lotIdParkingLotMap.entrySet().stream()
                .max(Comparator.comparingDouble(o -> o.getValue().getFreeSpaceRate()));
    }
}
