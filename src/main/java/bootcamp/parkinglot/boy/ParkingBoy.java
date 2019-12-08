package bootcamp.parkinglot.boy;

import bootcamp.parkinglot.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingBoy extends BaseWorker {

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Optional<Map.Entry<Integer, ParkingLot>> getParkingLot() {
        return lotIdParkingLotMap.entrySet().stream()
                .filter(entry -> !entry.getValue().isFull()).min(Comparator.comparingInt(Map.Entry::getKey));
    }

}
