package bootcamp.parkinglot.boy;

import bootcamp.parkinglot.ParkingLot;
import bootcamp.parkinglot.boy.BaseBoy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingBoy extends BaseBoy {

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Optional<Map.Entry<Integer, ParkingLot>> getParkingLot() {
        return lotIdParkingLotMap.entrySet().stream()
                .filter(entry -> !entry.getValue().isFull()).min(Comparator.comparingInt(Map.Entry::getKey));
    }

}
